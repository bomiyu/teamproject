package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.NoticeVO;
import org.zerock.mapper.NoticeMapper;

import lombok.Setter;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Setter(onMethod_ = @Autowired)
	private NoticeMapper mapper;
	
	@Override
	public int getTotal() {
		return mapper.getTotalCount();
	}
	
	@Override
	public void register(NoticeVO notice) {
		mapper.insertSelectKey(notice);
	}
	
	@Override
	public NoticeVO get(Long no) {
		return mapper.read(no);
	}
	
	@Override
	public boolean modify(NoticeVO notice) {
		return mapper.update(notice) == 1;
	}
	
	@Override
	public boolean delete(Long no) {
		return mapper.delete(no) == 1;
	}
	
	@Override
	public List<NoticeVO> getList() {
		return mapper.getList();
	}
	
}
