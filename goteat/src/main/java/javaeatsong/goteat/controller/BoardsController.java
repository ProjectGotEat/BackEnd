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

import javaeatsong.goteat.service.BoardsService;
import javaeatsong.goteat.model.Boards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class BoardsController {

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
	
	@PostMapping("/board")
	   public ResponseEntity<String> postBoard(@RequestBody Boards board, @RequestHeader("uid") int uid) throws Exception {
			board.setUserId(uid);
			boardsService.postBoard(board);
			if(board.getIsUp()==1){
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