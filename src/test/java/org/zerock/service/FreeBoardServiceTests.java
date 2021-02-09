package org.zerock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.FCriteria;
import org.zerock.domain.FreeBoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class FreeBoardServiceTests {
	@Setter(onMethod_ = @Autowired)
	private FreeBoardService service;
	 
	@Setter(onMethod_ = @Autowired)
	private FreeBoardService mapper;
	
	@Test
	public void testExist() {
		 log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() throws Exception {
		FreeBoardVO vo = new FreeBoardVO();
		vo.setTitle("updateeeee");
		vo.setContent("새로 작성하는 내용updateeeee");
		vo.setMember_no(1);
		
		int before = mapper.getList().size();
		
		service.register(vo);
//
//		MemberVO mvo = new MemberVO();
//		mvo.setNo(1L);
//		mvo.setName("userbom00");
//		
//		
//		((HttpSession) session).setAttribute("member1",mvo);
		
		int after = mapper.getList().size();
		
		assertEquals(before + 1, after);
	}
	
	@Test
	public void testGetList() {
//		List<FreeBoardVO> list = service.getList();
		  FCriteria cri = new FCriteria(2, 10);
		  List<FreeBoardVO> list= service.getList(cri);
		  
		  assertNotNull(list);
//		  assertNotEquals(list.size(),0);
//		  assertEquals(list.size(),10);	
	
	}
	
	@Test
	public void testGet() {
		FreeBoardVO vo = new FreeBoardVO();
		vo.setTitle("updateeeee");
		vo.setContent("새로 작성하는 내용updateeeee");
		vo.setMember_no(1);
		
		service.register(vo);

		FreeBoardVO getvo = service.get(vo.getNo());
		
		assertNotNull(getvo);
		assertEquals(getvo.getNo(), vo.getNo());
		
	}
	
	@Test
	public void testDelete() {
		FreeBoardVO vo = new FreeBoardVO();
		vo.setTitle("updateeeee");
		vo.setContent("새로 작성하는 내용updateeeee");
		vo.setMember_no(1);
		
		service.register(vo);
		
		assertTrue(service.remove(vo.getNo()));
	}
	
	@Test
	public void testUpdate() {
		FreeBoardVO vo = new FreeBoardVO();
		vo.setTitle("수정전 제목");
		vo.setContent("수정전 내용");
		vo.setMember_no(1);
		
		service.register(vo);
		
		
		FreeBoardVO up = new FreeBoardVO();
		up.setNo(vo.getNo());
		up.setTitle("수정된 제목");
		up.setContent("수정된 내용");
		up.setMember_no(1);
		
		assertTrue(service.modify(up));
		
		FreeBoardVO up2 = service.get(vo.getNo());
		
		log.info("생성된 게시물  번호>>>>>>" + vo.getNo());
		
		assertEquals("수정된 제목", up2.getTitle());
		assertEquals("수정된 내용", up2.getContent());
		
		
	}
}








