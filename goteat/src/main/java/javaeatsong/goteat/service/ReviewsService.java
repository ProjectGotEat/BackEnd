package javaeatsong.goteat.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaeatsong.goteat.repository.ReviewsMapper;
import javaeatsong.goteat.model.Reviews;

@Service
public class ReviewsService {

	@Autowired
	private ReviewsMapper reviewsMapper;

	public List<HashMap<String, Object>> getReview(String uid) throws Exception {
		return reviewsMapper.selectList(uid);
	}

	public void postReview(Reviews review) throws Exception {
		reviewsMapper.insert(review);
	}

	public void insertPointHistory(int userId) {
		reviewsMapper.insertPointHistory(userId);
	}
}
