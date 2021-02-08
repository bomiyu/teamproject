package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.FreeBoardVO;

public interface FreeBoardMapper {

	public int getTotalCount(Criteria cri); // SELECT count(*) FROM FreeBoard

	public List<FreeBoardVO> getList();

	public void insertSelectKey(FreeBoardVO vo);

	public FreeBoardVO get(Long no);

	public int delete(Long no);

	public List<FreeBoardVO> getListWithPaging(Criteria cri);

	public int update(FreeBoardVO vo);

//	public void updateCnt(@Param("no") Long no, @Param("amount") int amount);

}
