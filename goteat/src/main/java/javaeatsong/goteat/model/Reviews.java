package javaeatsong.goteat.model;

import java.sql.Timestamp;

public class Reviews {
	private Integer id;
	private Integer participantId;
	private Integer reviewerId;
	private Integer revieweeId;
	private Integer rate;
	private String content;
	private Timestamp createdAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParticipantId() {
		return participantId;
	}

	public void setParticipantId(Integer participantId) {
		this.participantId = participantId;
	}

	public Integer getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(Integer reviewerId) {
		this.reviewerId = reviewerId;
	}

	public Integer getRevieweeId() {
		return revieweeId;
	}

	public void setRevieweeId(Integer revieweeId) {
		this.revieweeId = revieweeId;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "ReviewsDTO [id=" + id + ", participantId=" + participantId + ", reviewerId=" + reviewerId + ", revieweeId="
				+ revieweeId + ", rate=" + rate + ", content=" + content + ", createdAt=" + createdAt + "]";
	}
}
