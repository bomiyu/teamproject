package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.NReplyVO;
import org.zerock.mapper.NReplyMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NReplyServiceImpl implements NReplyService {
	
	private NReplyMapper mapper;
	
	@Override
	public int getTotal() {
		return mapper.getTotalCount();
	}
	
	@Override
	public void register(NReplyVO reply) {
		mapper.insertSelectKey(reply);
	}
	
	@Override
	public NReplyVO get(Long no) {
		return mapper.read(no);
	}
	
	@Override
	public boolean modify(NReplyVO reply) {
		return mapper.update(reply) == 1;
	}
	
	@Override
	public boolean delete(Long no) {
		return mapper.delete(no) == 1;
	}
	
	@Override
	public List<NReplyVO> getList() {
		return mapper.getList();
	}
}
