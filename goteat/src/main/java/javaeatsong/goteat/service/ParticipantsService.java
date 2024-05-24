package javaeatsong.goteat.service;

import java.util.List;
import java.util.ArrayList;
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
		List<HashMap<String, Object>> participantsList = participantsMapper.selectListByOrganizerId(uid);
		participantsList.forEach(participants -> {
			int personal_quantity = (int) participants.get("quantity") / (int) participants.get("headcnt");
			String card_title = String.valueOf(participants.get("item_name"))+ " " + Integer.toString(personal_quantity) + String.valueOf(participants.get("scale"));
			participants.put("title", card_title);
		});

		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();

		for (int i = 0; i < participantsList.size(); i++) {
			Object title = participantsList.get(i).get("title");
			Object meeting_time = participantsList.get(i).get("meeting_time");
			Object content = participantsList.get(i).get("content");

			HashMap<String, Object> participant = new HashMap<String, Object>();
			participant.put("title", title);
			participant.put("meeting_time", meeting_time);
			participant.put("message", content);

			data.add(participant);
		};

		return data;
	}

	// 내가 참여한 소분 전체 조회
	public List<HashMap<String, Object>> getParticipantsParticipating(int uid) throws Exception {
		List<HashMap<String, Object>> participantsList = participantsMapper.selectListByUserId(uid);
		participantsList.forEach(participants -> {
			int personal_quantity = (int) participants.get("quantity") / (int) participants.get("headcnt");
			String card_title = String.valueOf(participants.get("item_name")) + " " + Integer.toString(personal_quantity) + String.valueOf(participants.get("scale"));
			participants.put("title", card_title);
		});

		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();

		for (int i = 0; i < participantsList.size(); i++) {
			Object title = participantsList.get(i).get("title");
			Object meeting_time = participantsList.get(i).get("meeting_time");
			Object content = participantsList.get(i).get("content");

			HashMap<String, Object> participant = new HashMap<String, Object>();
			participant.put("title", title);
			participant.put("meeting_time", meeting_time);
			participant.put("message", content);

			data.add(participant);
		};

		return data;
	}
}
