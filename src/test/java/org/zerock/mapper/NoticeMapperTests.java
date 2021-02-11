package org.zerock.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.NoticeVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class NoticeMapperTests {

	@Setter(onMethod_ = @Autowired)
	private NoticeMapper mapper;
	
	@Test
	public void testGetTotalCount() {
		int cnt = mapper.getTotalCount();
		log.info(cnt);
	}
	
	@Test
	public void testInsertSelectKey() {
		NoticeVO vo = new NoticeVO();
		vo.setCategory("event");
		vo.setTitle("title");
		vo.setContent("content");
		vo.setMember_no(1);
		
		mapper.insertSelectKey(vo);
	}
	
	@Test
	public void testRead() {
		NoticeVO vo = mapper.read(1L);
		log.info(vo);
	}
	
	@Test
	public void testUpdateCnt() {
		NoticeVO vo = mapper.read(1L);
		log.info("before: " + vo.getCnt());
		
		int cnt = mapper.updateCnt(1L);
		log.info(cnt);
		
		vo = mapper.read(1L);
		log.info("after: " + vo.getCnt());
	}
	
	@Test
	public void testUpdate() {
		NoticeVO vo = new NoticeVO();
		vo.setNo(23);
		vo.setCategory("notice");
		vo.setTitle("new title");
		vo.setContent("new content");
		
		int cnt = mapper.update(vo);
		log.info(cnt);
	}
	
	@Test
	public void testDelete() {
		NoticeVO vo = new NoticeVO();
		vo.setTitle("title");
		vo.setContent("content");
		vo.setMember_no(1);
		
		mapper.insertSelectKey(vo);
		
		log.info("no: " + vo.getNo());
		
		int cnt = mapper.delete(vo.getNo());
		
		assertEquals(1, cnt);
		assertNull(mapper.read(vo.getNo()));
	}
	
	@Test
	public void testGetList() {
		log.info(mapper.getList());
	}

}
