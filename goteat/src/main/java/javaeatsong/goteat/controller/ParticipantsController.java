package javaeatsong.goteat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javaeatsong.goteat.model.Participants;
import javaeatsong.goteat.service.ParticipantsService;

import java.util.List;
import java.util.HashMap;

@RestController
public class ParticipantsController {

	private final ParticipantsService participantsService;

	public ParticipantsController(ParticipantsService participantsService) {
		this.participantsService = participantsService;
	}

	@PostMapping("/board/{id}/request")
	public ResponseEntity<String> postParticipant(@RequestBody Participants participant,
			@RequestHeader("uid") String uid, @PathVariable("id") int bid) throws Exception {
		participant.setUserId(Integer.valueOf(uid));
		participant.setBoardId(Integer.valueOf(bid));
		int result = participantsService.postParticipant(participant);
		if (result > 0) {
			return ResponseEntity.status(HttpStatus.CREATED).body("requested successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no remain_headcnt. remain_headcnt is 0");
		}
	}

	// 내가 주최한 소분 전체 조회
	@GetMapping("/participant/organize")
	public ResponseEntity<List<HashMap<String, Object>>> getPariticpantsOrganized(@RequestHeader("uid") int uid)
			throws Exception {
		List<HashMap<String, Object>> response_data = participantsService.getParticipantsOrganized(uid);
		if (response_data.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(response_data);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	// 내가 참여한 소분 전체 조회
	@GetMapping("/participant/participate")
	public ResponseEntity<List<HashMap<String, Object>>> getParticipantsParticipating(@RequestHeader("uid") int uid)
			throws Exception {
		List<HashMap<String, Object>> response_data = participantsService.getParticipantsParticipating(uid);
		if (response_data.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(response_data);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	// 종료된 소분 전체 조회
	@GetMapping("/participant/end")
	public ResponseEntity<List<HashMap<String, Object>>> getParticipantsEnded(@RequestHeader("uid") int uid)
			throws Exception {
		List<HashMap<String, Object>> response_data = participantsService.getParticipantsEnded(uid);
		if (response_data.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(response_data);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	// 1:1 쪽지 상세 조회 구현
	@GetMapping("/participant/{id}")
	public ResponseEntity<HashMap<String, Object>> getParticipantMessages(@PathVariable("id") int id,
			@RequestHeader("uid") int uid) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(participantsService.getParticipantMessages(id, uid));
	}

	// 쪽지 보내기
	@PostMapping("/participant/{id}")
	public ResponseEntity<String> postParticipantMessage(@PathVariable("id") int id, @RequestHeader("uid") int uid,
			@RequestBody HashMap<String, Object> message) throws Exception {
		int receiverId = (int) message.get("receiver_id");
		String content = (String) message.get("content");
		participantsService.postParticipantMessage(id, uid, receiverId, content);
		return ResponseEntity.status(HttpStatus.CREATED).body("message sent");
	}

	// 소분 성공 요청
	@PutMapping("/participant/{id}/success")
	public ResponseEntity<String> putParticipantSuccess(@PathVariable("id") int id, @RequestHeader("uid") int uid)
			throws Exception {
		if (participantsService.putParticipantSuccess(id, uid) == 1) {
			return ResponseEntity.status(HttpStatus.OK).body("participant got successfully succeed");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no matching participant");
		}
	}

	// 소분 실패 요청
	@PutMapping("participant/{id}/fail")
	public ResponseEntity<String> putParticipantFail(@PathVariable("id") int id, @RequestHeader("uid") int uid)
			throws Exception {
		if (participantsService.putParticipantFail(id, uid) == 1) {
			return ResponseEntity.status(HttpStatus.OK).body("participant got successfully failed");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no matching participant");
		}
	}
}