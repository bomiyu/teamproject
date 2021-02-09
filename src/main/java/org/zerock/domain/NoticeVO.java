package org.zerock.domain;

import java.util.Date;

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

}
