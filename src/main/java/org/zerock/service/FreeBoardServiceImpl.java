package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.FreeBoardVO;
import org.zerock.mapper.FreeBoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//@Component
@Service
@AllArgsConstructor
@Log4j
public class FreeBoardServiceImpl implements FreeBoardService {
	
	private FreeBoardMapper mapper;
	
	
	@Override
	public void register(FreeBoardVO vo) {
		mapper.insertSelectKey(vo);
	}
	
	
	@Override public List<FreeBoardVO> getList() { return mapper.getList(); }
	

//	@Override
//	public List<FreeBoardVO> getList(Criteria cri) {
//		return mapper.getListWithPaging(cri);
//	}
	
	@Override
	public FreeBoardVO get(Long no) {
		return mapper.read(no);
	}
	
	@Override
	public boolean remove(Long no) {
		return mapper.delete(no) == 1;
	}
	
	@Override
	public boolean modify(FreeBoardVO vo) {
		return mapper.update(vo) == 1;
	}
	
//	@Override
//	public int getTotal(Criteria cri) {
//		return mapper.getTotalCount(cri);
//	}
}






