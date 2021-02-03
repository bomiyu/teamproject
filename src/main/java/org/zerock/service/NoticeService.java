package org.zerock.service;

import java.util.List;

import org.zerock.domain.NoticeVO;

public interface NoticeService {

	public int getTotal();
	
	public void register(NoticeVO vo);
	
	public NoticeVO get(Long no);
	
	public boolean modify(NoticeVO vo);
	
	public boolean delete(Long no);
	
	public List<NoticeVO> getList();
	
}
