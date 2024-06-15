package javaeatsong.goteat.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import javaeatsong.goteat.service.ScrapsService;
import javaeatsong.goteat.model.Scraps;

import java.util.HashMap;
import java.util.List;

@RestController
public class ScrapsController {

	private final ScrapsService scrapsService;

	public ScrapsController(ScrapsService scrapsService) {
		this.scrapsService = scrapsService;
	}

	@GetMapping("/user/scrap")
	public List<HashMap<String, Object>> getScrap(@RequestHeader HttpHeaders header) throws Exception {
		return scrapsService.getScrap(header.getFirst("uid"));
	}

	@PostMapping("/board/{id}/scrap")
	public ResponseEntity<String> postScrap(@RequestHeader("uid") String uid, @PathVariable("id") int bid)
			throws Exception {
		Scraps scrap = new Scraps();
		scrap.setUserId(Integer.valueOf(uid));
		scrap.setBoardId(bid);
		scrapsService.postScrap(scrap);
		return ResponseEntity.status(HttpStatus.CREATED).body("Scrap created successfully");
	}

	@DeleteMapping("/board/{id}/scrap")
	public ResponseEntity<String> deleteScrap(@RequestHeader("uid") String uid, @PathVariable("id") int bid)
			throws Exception {
		Scraps scrap = new Scraps();
		scrap.setUserId(Integer.valueOf(uid));
		scrap.setBoardId(bid);
		scrapsService.deleteScrap(scrap);
		return ResponseEntity.status(HttpStatus.OK).body("Scrap deleted successfully");
	}
}