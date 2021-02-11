package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class NReplyVO {
	private long no;
	private String reply;
	private String replyer;
	private Date regdate;
	private Date updatedate;// 몇 분 전 수정 -> 몇 시간 전 수정
	private long notice_no;
}
