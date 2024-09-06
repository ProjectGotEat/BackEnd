package javaeatsong.goteat.service;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaeatsong.goteat.repository.ParticipantsMapper;
import javaeatsong.goteat.repository.BoardsMapper;
import javaeatsong.goteat.repository.MessagesMapper;
import javaeatsong.goteat.model.Participants;

@Service
public class ParticipantsService {

	@Autowired
	private ParticipantsMapper participantsMapper;

	@Autowired
	private BoardsMapper boardsMapper;

	@Autowired
	private MessagesMapper messagesMapper;

	// 소분 참여하기
	public int postParticipant(Participants participant) throws Exception {
		return participantsMapper.insert(participant);
	}

	// 내가 주최한 소분 전체 조회
	public List<HashMap<String, Object>> getParticipantsOrganized(int uid) throws Exception {
		List<HashMap<String, Object>> participantsList = participantsMapper.selectListByOrganizerId(uid);
		participantsList.forEach(participants -> {
			int personal_quantity = (int) participants.get("quantity") / (int) participants.get("headcnt");
			String card_title = String.valueOf(participants.get("item_name")) + " "
					+ Integer.toString(personal_quantity) + String.valueOf(participants.get("scale"));
			participants.put("title", card_title);
		});

		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();

		for (int i = 0; i < participantsList.size(); i++) {
			Object title = participantsList.get(i).get("title");
			Object meeting_time = participantsList.get(i).get("meeting_time");
			Object content = participantsList.get(i).get("content");
			Object id = participantsList.get(i).get("participant_id");
			Object organizer_id = participantsList.get(i).get("organizer_id");
			Object user_id = participantsList.get(i).get("user_id");

			HashMap<String, Object> participant = new HashMap<String, Object>();
			participant.put("id", id);
			participant.put("title", title);
			participant.put("meeting_time", meeting_time);
			participant.put("message", content);
			participant.put("organizer_id", organizer_id);
			participant.put("user_id", user_id);

			data.add(participant);
		}

		return data;
	}

	// 내가 참여한 소분 전체 조회
	public List<HashMap<String, Object>> getParticipantsParticipating(int uid) throws Exception {
		List<HashMap<String, Object>> participantsList = participantsMapper.selectListByUserId(uid);
		participantsList.forEach(participants -> {
			int personal_quantity = (int) participants.get("quantity") / (int) participants.get("headcnt");
			String card_title = String.valueOf(participants.get("item_name")) + " "
					+ Integer.toString(personal_quantity) + String.valueOf(participants.get("scale"));
			participants.put("title", card_title);
		});

		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();

		for (int i = 0; i < participantsList.size(); i++) {
			Object title = participantsList.get(i).get("title");
			Object meeting_time = participantsList.get(i).get("meeting_time");
			Object content = participantsList.get(i).get("content");
			Object id = participantsList.get(i).get("participant_id");
			Object organizer_id = participantsList.get(i).get("organizer_id");
			Object user_id = participantsList.get(i).get("user_id");

			HashMap<String, Object> participant = new HashMap<String, Object>();
			participant.put("id", id);
			participant.put("title", title);
			participant.put("meeting_time", meeting_time);
			participant.put("message", content);
			participant.put("organizer_id", organizer_id);
			participant.put("user_id", user_id);

			data.add(participant);
		}

		return data;
	}

	// 종료된 소분 게시글 전체 조회
	public List<HashMap<String, Object>> getParticipantsEnded(int uid) throws Exception {
		List<HashMap<String, Object>> participantsList = participantsMapper.selectListEndedByOrganizerUserId(uid);
		participantsList.forEach(participants -> {
			int personal_quantity = (int) participants.get("quantity") / (int) participants.get("headcnt");
			String card_title = String.valueOf(participants.get("item_name")) + " "
					+ Integer.toString(personal_quantity) + String.valueOf(participants.get("scale"));
			participants.put("title", card_title);
		});

		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();

		for (int i = 0; i < participantsList.size(); i++) {
			Object title = participantsList.get(i).get("title");
			Object meeting_time = participantsList.get(i).get("meeting_time");
			Object content = participantsList.get(i).get("content");
			Object id = participantsList.get(i).get("participant_id");
			Object organizer_id = participantsList.get(i).get("organizer_id");
			Object user_id = participantsList.get(i).get("user_id");
			Object has_review = participantsList.get(i).get("has_review");
			Object has_report = participantsList.get(i).get("has_report");

			HashMap<String, Object> participant = new HashMap<String, Object>();
			participant.put("id", id);
			participant.put("title", title);
			participant.put("meeting_time", meeting_time);
			participant.put("message", content);
			participant.put("organizer_id", organizer_id);
			participant.put("user_id", user_id);
			participant.put("has_review", has_review);
			participant.put("has_report", has_report);

			data.add(participant);
		}

		return data;
	}

	// 1:1 쪽지 상세 내역 조회
	public HashMap<String, Object> getParticipantMessages(int pid, int uid) throws Exception {
		HashMap<String, Object> boardOverview = boardsMapper.selectOverview(pid);

		String title = new String();
		String item_name = (String) boardOverview.get("item_name");
		String scale = (String) boardOverview.get("scale");
		int quantity = (int) boardOverview.get("quantity");
		int headcnt = (int) boardOverview.get("headcnt");
		int personal_quantity = quantity / headcnt;
		title = item_name + " " + Integer.toString(personal_quantity) + scale;
		boardOverview.put("title", title);
		boardOverview.remove("item_name");
		boardOverview.remove("scale");
		boardOverview.remove("headcnt");
		boardOverview.remove("quantity");

		List<HashMap<String, Object>> messages = participantsMapper.selectListMessages(pid, uid);

		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("boardOverview", boardOverview);
		data.put("messages", messages);
		return data;
	}

	// 쪽지 보내기
	public int postParticipantMessage(int pid, int uid, int receiverId, String content) throws Exception {
		return messagesMapper.insert(pid, uid, receiverId, content);
	}

	// 소분 성공 처리
	public int putParticipantSuccess(int pid, int uid) throws Exception {
		if (participantsMapper.updateIsSuccess(pid, uid) == 1) {
			participantsMapper.updateIsFinished(pid);
			return 1;
		} else {
			return 0;
		}
	}

	// 소분 실패 처리
	public int putParticipantFail(int pid, int uid) throws Exception {
		if (participantsMapper.updateIsFailed(pid, uid) == 1) {
			return 1;
		} else {
			return 0;
		}
	}
}
