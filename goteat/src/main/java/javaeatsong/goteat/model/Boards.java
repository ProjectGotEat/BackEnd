package javaeatsong.goteat.model;

import lombok.*;
import java.sql.Timestamp;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Boards {
	private Integer id;
    @JsonProperty("user_id")
	private Integer userId;
    @JsonProperty("category")
	private String categoryId;
    @JsonProperty("item_name")
	private String itemName;
	private Integer headcnt;
    @JsonProperty("remain_headcnt")
	private Integer remainHeadcnt;
	private Integer quantity;
	private String scale;
    @JsonProperty("total_price")
	private Integer totalPrice;
    @JsonProperty("meeting_location")
	private String meetingLocation;
    @JsonProperty("meeting_time")
	private Date meetingTime;
    @JsonProperty("is_up")
	private Boolean isUp;
    @JsonProperty("item_image1")
	private String itemImage1;
    @JsonProperty("item_image2")
	private String itemImage2;
    @JsonProperty("receipt_image")
	private String receiptImage;
	private double latitude;
	private double longitude;
    @JsonProperty("is_reusable")
	private Boolean isReusable;
	private Boolean isFinished;
	private Timestamp createdAt;
	private Timestamp updatedAt;

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

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getHeadcnt() {
		return headcnt;
	}

	public void setHeadcnt(Integer headcnt) {
		this.headcnt = headcnt;
	}

	public Integer getRemainHeadcnt() {
		return remainHeadcnt;
	}

	public void setRemainHeadcnt(Integer remainHeadcnt) {
		this.remainHeadcnt = remainHeadcnt;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getMeetingLocation() {
		return meetingLocation;
	}

	public void setMeetingLocation(String meetingLocation) {
		this.meetingLocation = meetingLocation;
	}

	public Date getMeetingTime() {
		return meetingTime;
	}

	public void setMeetingTime(Date meetingTime) {
		this.meetingTime = meetingTime;
	}

	public Boolean getIsUp() {
		return isUp;
	}

	public void setIsUp(Boolean isUp) {
		this.isUp = isUp;
	}

	public String getItemImage1() {
		return itemImage1;
	}

	public void setItemImage1(String itemImage1) {
		this.itemImage1 = itemImage1;
	}

	public String getItemImage2() {
		return itemImage2;
	}

	public void setItemImage2(String itemImage2) {
		this.itemImage2 = itemImage2;
	}

	public String getReceiptImage() {
		return receiptImage;
	}

	public void setReceiptImage(String receiptImage) {
		this.receiptImage = receiptImage;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Boolean getIsReusable() {
		return isReusable;
	}

	public void setIsReusable(Boolean isReusable) {
		this.isReusable = isReusable;
	}

	public Boolean getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(Boolean isFinished) {
		this.isFinished = isFinished;
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
		return "BoardsDTO [id=" + id + ", userId=" + userId + ", categoryId=" + categoryId + ", itemName=" + itemName
				+ ", headcnt=" + headcnt + ", remainHeadcnt=" + remainHeadcnt + ", quantity=" + quantity + ", scale="
				+ scale + ", totalPrice=" + totalPrice + ", meetingLocation=" + meetingLocation + ", meetingTime="
				+ meetingTime + ", isUp=" + isUp + ", itemImage1=" + itemImage1 + ", itemImage2=" + itemImage2
				+ ", receiptImage=" + receiptImage + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", isReusable=" + isReusable + ", isFinished=" + isFinished + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

}
