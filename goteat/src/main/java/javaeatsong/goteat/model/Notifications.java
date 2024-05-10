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
public class Notifications {
	private Integer id;
	private Integer notiType;
	private Integer receiveUid;
	private Integer sendUid;
	private Integer sendBid;
	private String message;
	private Timestamp createdAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNotiType() {
		return notiType;
	}

	public void setNotiType(Integer notiType) {
		this.notiType = notiType;
	}

	public Integer getReceiveUid() {
		return receiveUid;
	}

	public void setReceiveUid(Integer receiveUid) {
		this.receiveUid = receiveUid;
	}

	public Integer getSendUid() {
		return sendUid;
	}

	public void setSendUid(Integer sendUid) {
		this.sendUid = sendUid;
	}

	public Integer getSendBid() {
		return sendBid;
	}

	public void setSendBid(Integer sendBid) {
		this.sendBid = sendBid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "NotificationsDTO [id=" + id + ", notiType=" + notiType + ", receiveUid=" + receiveUid + ", sendUid="
				+ sendUid + ", sendBid=" + sendBid + ", message=" + message + ", createdAt=" + createdAt + "]";
	}
}
