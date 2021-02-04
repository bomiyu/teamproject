package org.zerock.service;

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
public class NoticeServiceTests {

	@Setter(onMethod_ = @Autowired)
	private NoticeService service;
	
	@Test
	public void testGetTotal() {
		log.info(service.getTotal());
	}
	
	@Test
	public void testRegister() {
		NoticeVO vo = new NoticeVO();
		vo.setCategory("event");
		vo.setTitle("title");
		vo.setContent("content");
		vo.setMember_no(2);
		
		service.register(vo);
	}
	
	@Test
	public void testGet() {
		log.info(service.get(6L));
	}
	
	@Test
	public void testModify() {
		NoticeVO vo = new NoticeVO();
		vo.setNo(6);
		vo.setCategory("event");
		vo.setTitle("new title");
		vo.setContent("new content");
		
		log.info(service.modify(vo));
		log.info(service.get(6L));
	}
	
	@Test
	public void testDelete() {
		NoticeVO vo = new NoticeVO();
		vo.setTitle("title");
		vo.setContent("content");
		vo.setMember_no(2);
		
		service.register(vo);
		
		int before = service.getTotal();
		
		service.delete(vo.getNo());
		
		int after = service.getTotal();
		
		log.info("before: " + before + ", after: " + after);
		assertEquals(before + 1, after);
		assertNull(service.get(vo.getNo()));
	}
	
	@Test
	public void testGetList() {
		log.info(service.getList());
	}

}
