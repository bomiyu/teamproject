package org.zerock.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.FreeBoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class FreeBoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private FreeBoardMapper mapper;

	@Test
	public void testGetList() {
		List<FreeBoardVO> list = mapper.getList();

		assertNotEquals(list.size(), 0);
	}

	@Test
	public void testInsertSelectKey() {
		FreeBoardVO vo = new FreeBoardVO();
		vo.setTitle("222test새로 작성하는 제목");
		vo.setContent("222test새로 작성하는 내용");
		vo.setMember_no(1);

		int before = mapper.getList().size();

		mapper.insertSelectKey(vo);

		int after = mapper.getList().size();

		assertEquals(before + 1, after);
		assertNotEquals(vo.getNo(), new Long(1L));

	}

	@Test
	public void testRead() {
		FreeBoardVO vo = new FreeBoardVO();
		vo.setTitle("readtest");
		vo.setContent("새로 작성하는 내용readtest");
		vo.setMember_no(1);

		int before = mapper.getList().size();

		mapper.insertSelectKey(vo);// 새로등록한 게시물까지완료, 읽혀지면됨

		FreeBoardVO readvo = mapper.get(vo.getNo());
		log.info(readvo);
		assertNotNull(readvo);

	}

	@Test
	public void testDelete() {
		FreeBoardVO vo = new FreeBoardVO();
		vo.setTitle("제목");
		vo.setContent("삭제test");
		vo.setMember_no(1);

		mapper.insertSelectKey(vo);

		int before = mapper.getList().size();

		int cnt = mapper.delete(vo.getNo());
		assertEquals(1, cnt);
		int after = mapper.getList().size();

		assertEquals(before - 1, after);
	}

	@Test
	public void testUpdate() {
		FreeBoardVO vo = new FreeBoardVO();
		vo.setTitle("updateeeee");
		vo.setContent("새로 작성하는 내용updateeeee");
		vo.setMember_no(1);

		mapper.insertSelectKey(vo);

		vo.setTitle("변경된 제목~~~");
		vo.setContent("변경된 내용updateeeee~!");
		int cnt = mapper.update(vo);

		assertEquals(1, cnt);

		FreeBoardVO updateVO = mapper.get(vo.getNo());
		assertEquals("변경된 제목~~~", updateVO.getTitle());
		assertEquals("변경된 내용updateeeee~!", updateVO.getContent());

	}

	@Test
	public void testPaging() {
		Criteria cri = new Criteria(1, 5);
		List<FreeBoardVO> list = mapper.getListWithPaging(cri);

		assertEquals(10, list.size());

		cri = new Criteria(1, 10);
		list = mapper.getListWithPaging(cri);

		assertEquals(10, list.size());
		/*
		 * cri = new Criteria(2, 5); // 2페이지의 5개 list = mapper.getListWithPaging(cri);
		 * 
		 * list.forEach(vo -> log.info("게시물 번호만 출력하도록: " + vo.getNo()));
		 */
	}

}
