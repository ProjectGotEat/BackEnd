package javaeatsong.goteat.service;

import java.util.Date;
import java.util.List;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaeatsong.goteat.model.Participants;
import javaeatsong.goteat.repository.ParticipantsMapper;

@Service
public class ParticipantsService {

	@Autowired
	private ParticipantsMapper participantsMapper;
	
	// 내가 주최한 소분 전체 조회
	public List<HashMap<String, Object>> getParticipantsOrganized(int uid) throws Exception {
		List<HashMap<String, Object>> participantsList = participantsMapper.selectList(uid);
		return participantsList;
	}

}
