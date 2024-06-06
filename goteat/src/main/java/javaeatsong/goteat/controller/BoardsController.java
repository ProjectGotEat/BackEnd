package javaeatsong.goteat.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;

import javaeatsong.goteat.service.BoardsService;
import javaeatsong.goteat.model.Boards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class BoardsController {

    @Value("${file.upload-dir}")
    private String uploadDir;
	
	private final BoardsService boardsService;

	public BoardsController(BoardsService boardsService) {
		this.boardsService = boardsService;
	}

	@GetMapping("/board")
	public ResponseEntity<List<HashMap<String, Object>>> getBoard(@RequestHeader HttpHeaders header) throws Exception {
		String uid = header.getFirst("uid");
		String keyword = "";
		String category = "";

		if (uid == null || uid.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
		}

		return ResponseEntity.status(HttpStatus.OK).body(boardsService.getBoard(uid, keyword, category));
	}

	@GetMapping("/board/search")
	public ResponseEntity<List<HashMap<String, Object>>> getBoardByKeywordCategories(
			@RequestParam("keyword") String keyword, @RequestParam("category") String category,
			@RequestHeader HttpHeaders header) throws Exception {
		String uid = header.getFirst("uid");

		if (uid == null || uid.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
		}

		return ResponseEntity.status(HttpStatus.OK).body(boardsService.getBoard(uid, keyword, category));
	}
	
	@GetMapping("/board/{id}")
	public HashMap<String, Object> getBoardDetail(@PathVariable("id") int bid,
			@RequestHeader("uid") String uid) throws Exception {
		return boardsService.getBoardDetail(uid, bid);
	}
	

	@PostMapping(value = "/board", consumes = "multipart/form-data")
    public ResponseEntity<String> postBoard(
            @RequestPart("item_image1") MultipartFile itemImage1,
            @RequestPart("receipt_image") MultipartFile itemImage2,
            @RequestPart("board") String boardJson,
            @RequestHeader("uid") int uid) throws Exception {

        // JSON 문자열을 Boards 객체로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        Boards board = objectMapper.readValue(boardJson, Boards.class);

        board.setUserId(uid);

        // 파일 처리
        if (!itemImage1.isEmpty()) {
            try {
                Path path = Paths.get(uploadDir + File.separator + itemImage1.getOriginalFilename());
                Files.write(path, itemImage1.getBytes());
                String fileUrl = "http://localhost:8080/uploads/" + itemImage1.getOriginalFilename();
                board.setItemImage1(fileUrl);
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload item_image1");
            }
        }

        if (!itemImage2.isEmpty()) {
            try {
                Path path = Paths.get(uploadDir + File.separator + itemImage2.getOriginalFilename());
                Files.write(path, itemImage2.getBytes());
                String fileUrl = "http://localhost:8080/uploads/" + itemImage2.getOriginalFilename();
                board.setReceiptImage(fileUrl); // Assuming you have this field in your Boards model
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload item_image2");
            }
        }

        boardsService.postBoard(board);
        if (board.getIsUp() != null && board.getIsUp()) {
            boardsService.insertPointHistory(uid);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Board created successfully");
    }
	
	@PutMapping("/board/{id}/request")
	public ResponseEntity<String> decrementReaminHeadcnt(@PathVariable("id") int bid) throws Exception {
		boardsService.decrementRemainHeadcnt(bid);
       return ResponseEntity.status(HttpStatus.CREATED).body("Remain Headcnt decremented successfully");
	}
}