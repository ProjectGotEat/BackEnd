package javaeatsong.goteat.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import javaeatsong.goteat.service.ReviewsService;
import javaeatsong.goteat.model.Reviews;

import java.util.HashMap;
import java.util.List;

@RestController
@MapperScan(basePackages = "javaeatsong.goteat.repository") // 탐색할 패키지 설정
public class ReviewsController {

	private final ReviewsService reviewsService;

	public ReviewsController(ReviewsService reviewsService) {
		this.reviewsService = reviewsService;
	}

	@GetMapping("/user/review")
	public List<HashMap<String, Object>> getReview(@RequestHeader HttpHeaders header) throws Exception {
		return reviewsService.getReview(header.getFirst("uid"));
	}
	
	
	@PostMapping("/participant/{id}/review")
	   public ResponseEntity<String> postReview(@RequestBody Reviews review, @RequestHeader("uid") int uid, @PathVariable("id") int pid)
			   throws Exception {
		review.setReviewerId(uid); //리뷰하는 사람 ID 세팅
		review.setParticipantId(pid);
		reviewsService.postReview(review);
		reviewsService.insertPointHistory(uid);
	    return ResponseEntity.status(HttpStatus.CREATED).body("Review created successfully");
    }
}