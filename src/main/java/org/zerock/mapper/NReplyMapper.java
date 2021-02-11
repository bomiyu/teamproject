package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.NReplyVO;

public interface NReplyMapper {
	
	public int getTotalCount();
	
	public void insertSelectKey(NReplyVO reply);
	
	public NReplyVO read(Long no);
	
	public int update(NReplyVO reply);
	
	public int delete(Long no);
	
	public List<NReplyVO> getList();
	
	// 10개씩 댓글 로딩하려면 스크롤이 바닥쳤을 때 ajax로 10개 추가 로딩해야 함,,,ㅎ,,,,
}
