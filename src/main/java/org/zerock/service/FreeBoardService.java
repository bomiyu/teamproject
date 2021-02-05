package org.zerock.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.zerock.domain.Criteria;
import org.zerock.domain.FreeBoardVO;
import org.zerock.domain.MemberVO;

public interface FreeBoardService {

	public void register(FreeBoardVO vo);

	public List<FreeBoardVO> getList();
//	public List<FreeBoardVO> getList(Criteria cri);

	public FreeBoardVO get(Long no);

	public boolean remove(Long no);

	public boolean modify(FreeBoardVO vo);
//	
//	public int getTotal(Criteria cri);

}
