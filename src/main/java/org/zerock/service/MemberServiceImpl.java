package org.zerock.service;

import org.springframework.stereotype.Service;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service //서비스 bean 객체 생성
@AllArgsConstructor	//생성자 생성
@Log4j
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper mapper;
	
	//회원 등록
	@Override
	public void register(MemberVO member) {
		mapper.insertSelectKey(member);
	}
	
	//회원 정보 읽기 - 아이디
	@Override
	public MemberVO getMember(String id) {
		return mapper.readMember(id);
	}
	
	//회원 정보 읽기 - no
	//나중에도 사용하지않으면 지울 수 있음!
	//사용할 시 사용 여부 표시바람
	@Override
	public MemberVO get(Long no) {
		return mapper.read(no);
	}
	
	//회원 정보 수정
	@Override
	public boolean modify(MemberVO member) {
		return mapper.update(member) == 1;
	}

	//회원 탈퇴(삭제)
	@Override
	public boolean remove(Long no) {
		return mapper.delete(no) == 1;
	}
}
