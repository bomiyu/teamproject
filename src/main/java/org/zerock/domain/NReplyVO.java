package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class NReplyVO {
	private long no;
	private String reply;
	private String replyer;
	private Date regdate;
	private long notice_no;
}
