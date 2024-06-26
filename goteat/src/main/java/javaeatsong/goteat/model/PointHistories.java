package javaeatsong.goteat.model;

import java.sql.Timestamp;

public class PointHistories {
	private Integer id;
	private Integer boardId;
	private Integer organizerId;
	private Integer userId;
	private Integer isSuccess;
	private Integer isFailed;
	private Timestamp createdAt;
	private Timestamp updatedAt;

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

	public Integer getOrganizerId() {
		return organizerId;
	}

	public void setOrganizerId(Integer organizerId) {
		this.organizerId = organizerId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Integer isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Integer getIsFailed() {
		return isFailed;
	}

	public void setIsFailed(Integer isFailed) {
		this.isFailed = isFailed;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "PointHistoriesDTO [id=" + id + ", boardId=" + boardId + ", organizerId=" + organizerId + ", userId="
				+ userId + ", isSuccess=" + isSuccess + ", isFailed=" + isFailed + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
}
