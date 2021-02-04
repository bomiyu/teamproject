package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.FreeBoardVO;

public interface FreeBoardMapper {

	/*
	 * public int getTotalCount(Criteria cri); // SELECT count(*) FROM tbl_board
	 */
	public List<FreeBoardVO> getList();

	public void insertSelectKey(FreeBoardVO vo);

	public FreeBoardVO read(Long no);

	public int delete(Long no);

//	public List<FreeBoardVO> getListWithPaging(Criteria cri);
//
//	public int update(FreeBoardVO board);
//
//	public void updateReplyCnt(@Param("no") Long bno, @Param("amount") int amount);

}
