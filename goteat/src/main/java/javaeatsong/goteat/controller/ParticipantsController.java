package javaeatsong.goteat.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import javaeatsong.goteat.service.ParticipantsService;
import javaeatsong.goteat.model.Participants;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@MapperScan(basePackages = "javaeatsong.goteat.repository") // 탐색할 패키지 설정
public class ParticipantsController {

	private final ParticipantsService participantsService;

	public ParticipantsController(ParticipantsService participantsService) {
		this.participantsService = participantsService;
	}

	@PostMapping("/board/{id}/request")
	   public ResponseEntity<String> postParticiipant(@RequestBody Participants participant, @RequestHeader("uid") String uid, @PathVariable("id") int bid)
		throws Exception {
			participant.setUserId(Integer.valueOf(uid));
			participant.setBoardId(Integer.valueOf(bid));
			participantsService.postParticipant(participant);
			return ResponseEntity.status(HttpStatus.CREATED).body("requested successfully");
    }
}