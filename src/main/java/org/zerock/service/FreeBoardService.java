package org.zerock.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.zerock.domain.FCriteria;
import org.zerock.domain.FreeBoardVO;
import org.zerock.domain.MemberVO;

public interface FreeBoardService {

	public void register(FreeBoardVO vo);

	public List<FreeBoardVO> getList();
	public List<FreeBoardVO> getList(FCriteria cri);//paging처리를 위한 code

	public FreeBoardVO get(Long no);

	public boolean remove(Long no);

	public boolean modify(FreeBoardVO vo);
	
	public int getTotal(FCriteria cri);

}
