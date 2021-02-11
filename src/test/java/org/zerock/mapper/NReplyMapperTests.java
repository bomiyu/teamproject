package org.zerock.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.NReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class NReplyMapperTests {

	@Setter(onMethod_ = @Autowired)
	private NReplyMapper mapper;
	
	@Test
	public void testGetTotalCount() {
		log.info("총 댓글 수: " + mapper.getTotalCount());
	}
	
	@Test
	public void testInsertSelectKey() {
		int before = mapper.getTotalCount();
		
		NReplyVO reply = new NReplyVO();
		reply.setReply("댓글rrrr");
		reply.setReplyer("은디2");
		reply.setNotice_no(242);
				
		mapper.insertSelectKey(reply);
		int after = mapper.getTotalCount();
		
		assertEquals(before + 1, after);
	}
	
	@Test
	public void testRead() {
		log.info(mapper.read(1L));
	}
	
	@Test
	public void testUpdate() {
		NReplyVO reply = new NReplyVO();
		//reply.setNo(1);
		reply.setReply("첫댓 수정");
		
		mapper.update(reply);
		log.info(mapper.read(1L));
	}
	
	@Test
	public void testDelete() {
		NReplyVO reply = new NReplyVO();
		reply.setReply("댓글rrr");
		reply.setReplyer("은디아님");
		reply.setNotice_no(242);
				
		mapper.insertSelectKey(reply);
		int before = mapper.getTotalCount();
		
		mapper.delete(reply.getNo());
		int after = mapper.getTotalCount();
		
		assertEquals(before-1, after);
	}
	
	@Test
	public void testGetList() {
		log.info(mapper.getList());
	}

}
