package com.activity_photo.model;

import java.io.Serializable;
import java.util.Arrays;

public class ActivityPhotoVO implements Serializable {
	private Integer id;
	private Integer activityId;
	private byte[] photo;

	public ActivityPhotoVO() {
	}

	public ActivityPhotoVO(Integer id, Integer activityId, byte[] photo) {
		this.id = id;
		this.activityId = activityId;
		this.photo = photo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "ActivityPhotoVO [id=" + id + ", activityId=" + activityId + ", photo=" + Arrays.toString(photo) + "]";
	}
}
