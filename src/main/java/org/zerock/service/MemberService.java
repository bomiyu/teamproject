package org.zerock.service;

import org.zerock.domain.MemberVO;

public interface MemberService {
	
	public void register(MemberVO member); //회원 등록
	public MemberVO getMember(String id);  //회원 정보 읽기 - 아이디 
	public MemberVO get(Long no); //회원 정보 읽기 - no
	public boolean modify(MemberVO member); //회원 정보 수정
	public boolean remove(Long no); //회원 탈퇴(삭제)
	
	
	
}
