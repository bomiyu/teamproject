package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.FreeBoardVO;

public interface FreeBoardService {

	public void register(FreeBoardVO vo);

	public List<FreeBoardVO> getList();
//	public List<FreeBoardVO> getList(Criteria cri);

	public FreeBoardVO get(Long vo);

	public boolean remove(Long no);

	public boolean modify(FreeBoardVO board);
//	
//	public int getTotal(Criteria cri);
}
