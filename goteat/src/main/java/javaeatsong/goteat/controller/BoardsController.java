package javaeatsong.goteat.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javaeatsong.goteat.service.BoardsService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@MapperScan(basePackages = "javaeatsong.goteat.repository") // 탐색할 패키지 설정
public class BoardsController {

	private final BoardsService boardsService;

	public BoardsController(BoardsService boardsService) {
		this.boardsService = boardsService;
	}

	@GetMapping("/board")
	public ResponseEntity<List<HashMap<String, Object>>> getBoard(@RequestHeader HttpHeaders header) throws Exception {
		String uid = header.getFirst("uid");
		String keyword = "";
		List<String> categories = null;

		if (uid == null || uid.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
		}

		return ResponseEntity.status(HttpStatus.OK).body(boardsService.getBoard(uid, keyword, categories));
	}

	@GetMapping("/board/search")
	public ResponseEntity<List<HashMap<String, Object>>> getBoardByKeywordCategories(
			@RequestParam("keyword") String keyword, @RequestParam("categories") List<String> categories,
			@RequestHeader HttpHeaders header) throws Exception {
		String uid = header.getFirst("uid");

		if (uid == null || uid.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
		}

		return ResponseEntity.status(HttpStatus.OK).body(boardsService.getBoard(uid, keyword, categories));
	}
}