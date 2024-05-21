package javaeatsong.goteat.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javaeatsong.goteat.model.Participants;
import javaeatsong.goteat.service.ParticipantsService;

import java.util.List;

@RestController
@MapperScan(basePackages = "javaeatsong.goteat.repository") // 탐색할 패키지 설정
public class ParticipantsController {

	private final ParticipantsService participantsService;

	public ParticipantsController(ParticipantsService participantsService) {
		this.participantsService = participantsService;
	}

	// 내가 주최한 소분 전체 조회
	@GetMapping("/participant/organize")
	public List<HashMap<String, Object>> getPariticpantsOrganized(@RequestHeader("uid") int uid) throws Exception {
		return participantsService.getParticipantsOrganized(uid)
	}

}