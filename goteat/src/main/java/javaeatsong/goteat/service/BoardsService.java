package javaeatsong.goteat.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaeatsong.goteat.repository.BoardsMapper;

@Service
public class BoardsService {

	@Autowired
	private BoardsMapper boardsMapper;

	public List<HashMap<String, Object>> getBoard(String uid, String keyword, String category)
			throws Exception {
		return boardsMapper.selectList(uid, keyword, category);
	}

}
