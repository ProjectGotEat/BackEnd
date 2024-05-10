package javaeatsong.goteat.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reviews {
	private Integer id;
	private Integer boardId;
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

	public Integer getBoardId() {
		return boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
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
		return "ReviewsDTO [id=" + id + ", boardId=" + boardId + ", reviewerId=" + reviewerId + ", revieweeId="
				+ revieweeId + ", rate=" + rate + ", content=" + content + ", createdAt=" + createdAt + "]";
	}
}
