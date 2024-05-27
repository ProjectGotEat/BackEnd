

package javaeatsong.goteat.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javaeatsong.goteat.model.Participants;
import javaeatsong.goteat.service.ParticipantsService;

import java.util.List;
import java.util.HashMap;

@RestController
@MapperScan(basePackages = "javaeatsong.goteat.repository") // 탐색할 패키지 설정
public class ParticipantsController {

	private final ParticipantsService participantsService;

	public ParticipantsController(ParticipantsService participantsService) {
		this.participantsService = participantsService;
	}

  
	@PostMapping("/board/{id}/request")
	public ResponseEntity<String> postParticipant(@RequestBody Participants participant, @RequestHeader("uid") String uid, @PathVariable("id") int bid) throws Exception {
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
	public List<HashMap<String, Object>> getPariticpantsOrganized(@RequestHeader("uid") int uid) throws Exception {
		return participantsService.getParticipantsOrganized(uid);
	}

	// 내가 참여한 소분 전체 조회
	@GetMapping("/participant/participate")
	public List<HashMap<String, Object>> getParticipantsParticipating(@RequestHeader("uid") int uid) throws Exception {
		return participantsService.getParticipantsParticipating(uid);
	}

	// 종료된 소분 전체 조회
	@GetMapping("/participant/end")
	public List<HashMap<String, Object>> getParticipantsEnded(@RequestHeader("uid") int uid) throws Exception {
		return participantsService.getParticipantsEnded(uid);
	}
}