package com.news.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

public class NewsVO implements Serializable {
	private Integer id;
	private String content;
	private byte[] image;
	private Timestamp date;
	private Integer type;

	public NewsVO() {
	}

	public NewsVO(Integer newsId, String newsContent, byte[] newsImg, Timestamp newsTime, Integer newsType) {
		this.id = newsId;
		this.content = newsContent;
		this.image = newsImg;
		this.date = newsTime;
		this.type = newsType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "NewsVO [id=" + id + ", content=" + content + ", image=" + Arrays.toString(image) + ", date=" + date
				+ ", type=" + type + "]";
	}
}

	
