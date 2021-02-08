package org.zerock.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.Criteria;
import org.zerock.domain.FreeBoardVO;
import org.zerock.mapper.FreeBoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@WebAppConfiguration // 테스트를 위한 어노테이션
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class FreeBoardControllerTests {

	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;

	@Setter(onMethod_ = @Autowired)
	private FreeBoardMapper mapper;

	private MockMvc mockMvc;

	@Before // 모든 test전에 매번실행
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testExist() {
		assertNotNull(ctx);
		assertNotNull(mockMvc);
	}

	@Test
	public void testList() throws Exception {
//		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/board/list"));
//		MvcResult rs = result.andReturn();
//		ModelAndView mv = rs.getModelAndView();
//		log.info(mv.getView());
//		log.info(mv.getModel().get("list"));

		ModelAndView mv = mockMvc.perform(MockMvcRequestBuilders.get("/freeboard/list")).andReturn().getModelAndView();

		Map<String, Object> model = mv.getModel();
		Object o = model.get("list");

		String viewName = mv.getViewName();

		log.info(viewName + "##################################");
		assertNotNull(o);
		assertTrue(o instanceof List);
		assertNotEquals(((List) o).size(), 0);
	}

	@Test
	public void testRegister() throws Exception {
		int before = mapper.getList().size();

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/freeboard/register").param("title", "고고새글 제목TEST")
						.param("content", "테스트 새글 내용").param("Member_no", "" + 1)) // 1을 string으로 형변환
				.andReturn();

		ModelAndView mv = result.getModelAndView();
		FlashMap map = result.getFlashMap();

		int after = mapper.getList().size();

		assertEquals(before + 1, after);
		assertEquals("redirect:/freeboard/list", mv.getViewName());
		assertNotNull(map.get("result"));

		log.info(map.get("result") + "*************************");

	}

	@Test
	public void testGet() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/freeboard/get").param("no", "1")).andReturn();
		String viewName = result.getModelAndView().getViewName();
		Map<String, Object> modelMap = result.getModelAndView().getModel();

		assertEquals("freeboard/get", viewName);
		assertNotNull(modelMap.get("vo"));
//		assertEquals(new Long(1), ((FreeBoardVO) modelMap.get("vo")).getNo());
	}

	@Test
	public void testModify() throws Exception {
		FreeBoardVO vo = new FreeBoardVO();
		vo.setContent("새 게시물");
		vo.setTitle("새 제목");
		vo.setMember_no(1);

		mapper.insertSelectKey(vo);

		Long key = vo.getNo();

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/freeboard/modify").param("no", key + "")
						.param("title", "kk수정된 게시물111").param("content", "kk수정된 본문1111").param("Member_no", "" + 1))
				.andReturn();

		FlashMap map = result.getFlashMap();
		String viewName = result.getModelAndView().getViewName();
		FreeBoardVO mod = mapper.get(key);

		assertEquals("kk수정된 게시물111", mod.getTitle());
		assertEquals("kk수정된 본문1111", mod.getContent());
		assertEquals("success", map.get("result"));
		assertEquals("redirect:/freeboard/list", viewName);
	}

	@Test
	public void testRemove() throws Exception {
		FreeBoardVO vo = new FreeBoardVO();
		vo.setContent("새 게시물");
		vo.setTitle("새 제목");
		vo.setMember_no(1);

		mapper.insertSelectKey(vo);

		Long key = vo.getNo();

		int before = mapper.getList().size();

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/freeboard/remove").param("no", key + ""))
				.andReturn();

		int after = mapper.getList().size();

		assertEquals(before - 1, after);

		String viewName = result.getModelAndView().getViewName();

		assertEquals("redirect:/freeboard/list", viewName);

		assertEquals("success", result.getFlashMap().get("result"));
	}


	@Test
	public void testListPaging() throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/freeboard/list").param("pageNum", "3").param("amount", "10"))
				.andReturn();

		Map<String, Object> model = result.getModelAndView().getModel();
		List list = (List) model.get("list");

		assertEquals(10, list.size());
	}
}
