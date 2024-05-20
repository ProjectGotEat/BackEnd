package javaeatsong.goteat.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import javaeatsong.goteat.service.BoardsService;
import javaeatsong.goteat.model.Boards;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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
	
	@GetMapping("/board/{id}")
	public HashMap<String, Object> getBoardDetail(@PathVariable("id") int bid,
			@RequestHeader("uid") String uid) throws Exception {
		return boardsService.getBoardDetail(uid, bid);
	}
	
	@PostMapping("/board")
	   public ResponseEntity<String> postBoard(@RequestBody Boards board, @RequestHeader("uid") String uid) throws Exception {
			board.setUserId(Integer.valueOf(uid));
			

		    // 로깅
		    Logger logger = LoggerFactory.getLogger(getClass());
		    logger.info("Received board data: {}", board);
		    
		    
			boardsService.postBoard(board);
	       return ResponseEntity.status(HttpStatus.CREATED).body("Board created successfully");
    }
}