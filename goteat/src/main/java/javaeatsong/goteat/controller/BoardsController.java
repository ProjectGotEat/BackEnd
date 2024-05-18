package javaeatsong.goteat.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javaeatsong.goteat.service.BoardsService;

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
	public List<HashMap<String, Object>> getBoard(@RequestHeader HttpHeaders header) throws Exception {
		return boardsService.getBoard(header.getFirst("uid"), "", null);
	}

	@GetMapping("/board/search")
	public List<HashMap<String, Object>> getBoardByKeywordCategories(@RequestParam("keyword") String keyword,
			@RequestParam("categories") List<String> categories, @RequestHeader HttpHeaders header) throws Exception {
		return boardsService.getBoard(header.getFirst("uid"), keyword, categories);
	}
}