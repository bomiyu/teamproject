package org.zerock.domain;
import lombok.Data;


@Data
public class MemberVO {
	private long no;
	private String id;
	private String email;
	private String password;
	private String name;
	private String nickname;
	private String loc;
}