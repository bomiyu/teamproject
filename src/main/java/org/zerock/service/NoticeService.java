package org.zerock.service;

import java.util.List;

import org.zerock.domain.NCriteria;
import org.zerock.domain.NoticeVO;

public interface NoticeService {

	public int getTotal();
	
	public void register(NoticeVO notice);
	
	public NoticeVO get(Long no);
	
	public NoticeVO getWithCnt(Long no);
	
	public boolean modify(NoticeVO notice);
	
	public boolean delete(Long no);
	
	public List<NoticeVO> getList();

	public List<NoticeVO> getList(NCriteria cri);
}
