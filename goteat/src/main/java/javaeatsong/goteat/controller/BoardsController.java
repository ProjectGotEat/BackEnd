package javaeatsong.goteat.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javaeatsong.goteat.model.Boards;
import javaeatsong.goteat.service.BoardsService;

import java.util.List;

@RestController
@MapperScan(basePackages = "javaeatsong.goteat.repository") // 탐색할 패키지 설정
public class BoardsController {

	private final BoardsService boardsService;

	public BoardsController(BoardsService boardsService) {
		this.boardsService = boardsService;
	}

	// 참고용 테스트 코드. 삭제 가능
	@GetMapping("/board")
	public List<Boards> getBoardsAll() throws Exception {
		return boardsService.getBoardsAll();
	}

	// 참고용 테스트 코드. 삭제 가능
	@GetMapping("/board/insert-test")
	public void insert(Boards board) throws Exception {
		boardsService.insert(board);
	}

	// 참고용 테스트 코드. 삭제 가능
	@GetMapping("/board/{id}")
	public Boards getUserProfile(@PathVariable("id") String id) throws Exception {
		return boardsService.getBoard(Integer.valueOf(id));
	}

}