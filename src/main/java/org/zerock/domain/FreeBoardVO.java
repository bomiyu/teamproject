package org.zerock.domain;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class FreeBoardVO {
	private Long no;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int cnt;//게시글 전체갯수
	private int member_no;
	private String userNickname; //게시글 회원닉네임 = 게시글 작성자 user_nickname
	
}
