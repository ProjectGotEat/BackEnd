package javaeatsong.goteat.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaeatsong.goteat.repository.BoardsMapper;
import javaeatsong.goteat.model.Boards;

@Service
public class BoardsService {

	@Autowired
	private BoardsMapper boardsMapper;

	public List<HashMap<String, Object>> getBoard(String uid, String keyword, List<String> categories)
			throws Exception {
		return boardsMapper.selectList(uid, keyword, categories);
	}

	public HashMap<String, Object> getBoardDetail(String uid, int bid)
			throws Exception {
		return boardsMapper.selectDetail(uid, bid);
	}

    public void postBoard(Boards board) throws Exception {
        boardsMapper.insert(board);
    }
    
    public void decrementRemainHeadcnt(int bid) throws Exception {
        boardsMapper.decrementRemainHeadcnt(bid);
    }
}
