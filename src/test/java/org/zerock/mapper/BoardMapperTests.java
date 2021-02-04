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
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private FreeBoardMapper mapper;

	/*
	 * @Test public void testSearch1() { Criteria cri = new Criteria();
	 * cri.setType("T"); cri.setKeyword("테스트");
	 * 
	 * mapper.getListWithPaging(cri);
	 * 
	 * }
	 * 
	 * @Test public void testSearch2() { Criteria cri = new Criteria();
	 * cri.setType("W"); cri.setKeyword("테스트");
	 * 
	 * mapper.getListWithPaging(cri);
	 * 
	 * }
	 * 
	 * @Test public void testSearch3() { Criteria cri = new Criteria();
	 * cri.setType("C"); cri.setKeyword("테스트");
	 * 
	 * mapper.getListWithPaging(cri);
	 * 
	 * }
	 * 
	 * @Test public void testSearch4() { Criteria cri = new Criteria();
	 * cri.setType("TC"); cri.setKeyword("테스트");
	 * 
	 * mapper.getListWithPaging(cri);
	 * 
	 * }
	 * 
	 * @Test public void testSearch5() { Criteria cri = new Criteria();
	 * cri.setType("TWC"); cri.setKeyword("테스트");
	 * 
	 * mapper.getListWithPaging(cri);
	 * 
	 * }
	 * 
	 * @Test public void testSearch6() { Criteria cri = new Criteria();
	 * cri.setType("TW"); cri.setKeyword("테스트");
	 * 
	 * mapper.getListWithPaging(cri);
	 * 
	 * }
	 */
//	@Test
//	public void testGetList() {
//		List<FreeBoardVO> list = mapper.getList();
//
//		assertNotEquals(list.size(), 0);
//	}



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

		FreeBoardVO readvo = mapper.read(51L);
		log.info(readvo);
		assertNotNull(readvo);

	}
	/*
	 * @Test public void testDelete() { BoardVO board = new BoardVO();
	 * board.setTitle("새로 작성하는 제목"); board.setContent("새로 작성하는 내용");
	 * board.setWriter("newbie");
	 * 
	 * mapper.insertSelectKey(board);
	 * 
	 * int before=mapper.getList().size();
	 * 
	 * int cnt = mapper.delete(board.getBno()); assertEquals(1, cnt); int after =
	 * mapper.getList().size();
	 * 
	 * assertEquals(before-1, after); }
	 * 
	 * @Test public void testUpdate() { BoardVO board = new BoardVO();
	 * board.setTitle("새로 작성하는 제목"); board.setContent("새로 작성하는 내용");
	 * board.setWriter("newbie");
	 * 
	 * mapper.insertSelectKey(board);
	 * 
	 * board.setTitle("변경된 제목"); board.setContent("변경된 내용~!"); int cnt =
	 * mapper.update(board);
	 * 
	 * assertEquals(1, cnt);
	 * 
	 * BoardVO updateVO = mapper.read(board.getBno()); assertEquals("변경된 제목",
	 * updateVO.getTitle()); assertEquals("변경된 내용~!", updateVO.getContent());
	 * 
	 * }
	 */
	/*
	 * 
	 * @Test public void testPaging() { Criteria cri = new Criteria(1, 5);
	 * List<BoardVO> list = mapper.getListWithPaging(cri);
	 * 
	 * assertEquals(5, list.size());
	 * 
	 * cri = new Criteria(1,10); list = mapper.getListWithPaging(cri);
	 * 
	 * assertEquals(10, list.size());
	 * 
	 * 
	 * cri = new Criteria(2,5); //2페이지의 5개 list = mapper.getListWithPaging(cri);
	 * 
	 * list.forEach(board -> log.info("게시물 번호만 출력하도록: "+board.getBno())); }
	 */
}
