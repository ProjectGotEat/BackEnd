package javaeatsong.goteat.model;

import java.sql.Date;
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
public class Users {
	private Integer id;
	private String name;
	private String profileName;
	private String image;
	private String email;
	private String password;
	private String rank;
	private Integer point;
	private Date suspensionDate;
	private Integer notiAllow;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Date getSuspensionDate() {
		return suspensionDate;
	}

	public void setSuspensionDate(Date suspensionDate) {
		this.suspensionDate = suspensionDate;
	}

	public Integer getNotiAllow() {
		return notiAllow;
	}

	public void setNotiAllow(Integer notiAllow) {
		this.notiAllow = notiAllow;
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
		return "UsersDTO [id=" + id + ", name=" + name + ", profileName=" + profileName + ", image=" + image
				+ ", email=" + email + ", password=" + password + ", rank=" + rank + ", point=" + point
				+ ", suspensionDate=" + suspensionDate + ", notiAllow=" + notiAllow + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
}
