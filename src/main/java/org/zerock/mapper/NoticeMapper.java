package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.NCriteria;
import org.zerock.domain.NoticeVO;

public interface NoticeMapper {

	public int getTotalCount();
	
	public void insertSelectKey(NoticeVO vo);
	
	public NoticeVO read(Long no);
	
	public int updateCnt(Long no);
	
	public int update(NoticeVO vo);
	
	public int delete(Long no);
	
	public List<NoticeVO> getList();
	
	public List<NoticeVO> getListWithPaging(NCriteria cri);
}
