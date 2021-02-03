package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.FreeBoardVO;

public interface FreeBoardMapper {
	
	public int getTotalCount(Criteria cri);
	// SELECT count(*) FROM tbl_board
	
	public List<FreeBoardVO> getList();
	
	public List<FreeBoardVO> getListWithPaging(Criteria cri);
	
	public void insert(FreeBoardVO board);

	public void insertSelectKey(FreeBoardVO board);
	// 1. seq_board의 nextval을 먼저 조회(select)
	// 2. 조회된 nextval을 insert에서 사용
	
	
	public FreeBoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(FreeBoardVO board);
	
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}






