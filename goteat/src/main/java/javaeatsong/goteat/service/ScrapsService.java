package javaeatsong.goteat.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaeatsong.goteat.repository.ScrapsMapper;
import javaeatsong.goteat.model.Scraps;

@Service
public class ScrapsService {

	@Autowired
	private ScrapsMapper scrapsMapper;

	public List<HashMap<String, Object>> getScrap(String uid) throws Exception {
		return scrapsMapper.selectList(uid);
	}

	public void postScrap(Scraps scrap) throws Exception {
		scrapsMapper.insert(scrap);
	}

	public void deleteScrap(Scraps scrap) throws Exception {
		scrapsMapper.delete(scrap);
	}
}
