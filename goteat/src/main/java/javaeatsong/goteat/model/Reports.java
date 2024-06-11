package javaeatsong.goteat.model;

import java.sql.Timestamp;

public class Reports {
	private Integer id;
	private Integer participantId;
	private Integer reporterId;
	private Integer reporteeId;
	private Integer categoryId;
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

	public Integer getReporterId() {
		return reporterId;
	}

	public void setReporterId(Integer reporterId) {
		this.reporterId = reporterId;
	}

	public Integer getReporteeId() {
		return reporteeId;
	}

	public void setReporteeId(Integer reporteeId) {
		this.reporteeId = reporteeId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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
		return "ReportsDTO [id=" + id + ", participantId=" + participantId + ", reporterId=" + reporterId
				+ ", reporteeId=" + reporteeId + ", categoryId=" + categoryId + ", content=" + content + ", createdAt="
				+ createdAt + "]";
	}
}
