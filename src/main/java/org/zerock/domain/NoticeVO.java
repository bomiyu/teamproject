package org.zerock.domain;

import java.util.Date;

import com.google.gson.GsonBuilder;

import lombok.Data;

@Data
public class NoticeVO {
	private long no;
	private String category;
	private String title;
	private String content;
	private Date regdate;// default sysdate
	private int cnt;// default 0
	private long member_no;
	private String nickname;// 추가 view: noticeInfo

	public String getJson() {// java object -> json
		return (new GsonBuilder()
		        .registerTypeAdapter(Date.class, new DateLongFormatTypeAdapter())
		        .create()).toJson(this);
	}
}
