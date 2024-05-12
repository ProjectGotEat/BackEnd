package javaeatsong.goteat.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaeatsong.goteat.model.Boards;
import javaeatsong.goteat.repository.BoardsMapper;

@Service
public class BoardsService {

	@Autowired
	private BoardsMapper boardsMapper;

	// 참고용 테스트 코드. 삭제 가능
	public List<Boards> getBoardsAll() throws Exception {
		List<Boards> boardsList = boardsMapper.selectList();
		return boardsList;
	}

	// 참고용 테스트 코드. 삭제 가능
	public void insert(Boards board) throws Exception {
		board.setId(2);
		board.setUserId(1);
		board.setCategoryId("0101");
		board.setItemName("itemName");
		board.setHeadcnt(2);
		board.setRemainHeadcnt(2);
		board.setQuantity(100);
		board.setScale("개");
		board.setTotalPrice(10000);
		board.setMeetingLocation("순헌관");
		board.setMeetingTime(new Date());
		board.setIsUp(0);
		board.setItemImage1("image1");
		board.setItemImage2("image2");
		board.setReceiptImage("receiptImage");
		board.setLatitude(4);
		board.setLongitude(10);
		board.setIsReusable(1);
		board.setIsFinished(0);
		boardsMapper.insert(board);
	}

	// 참고용 테스트 코드. 삭제 가능
	public Boards getBoard(int id) throws Exception {
		return boardsMapper.select(id);
	}

}
