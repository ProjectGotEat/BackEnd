package javaeatsong.goteat.model;

import java.sql.Timestamp;

public class Scraps {
	private Integer id;
	private Integer userId;
	private Integer boardId;
	private Timestamp createdAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBoardId() {
		return boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "ScrapsDTO [id=" + id + ", userId=" + userId + ", boardId=" + boardId + ", createdAt=" + createdAt + "]";
	}
}
