package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.NReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class NReplyServiceTests {

	@Setter(onMethod_ = @Autowired)
	private NReplyService service;
	
	@Test
	public void testEixst() {
		assertNotNull(service);
	}
	
	@Test
	public void testGetTotal() {
		log.info(service.getTotal());
	}
	
	@Test
	public void testRegister() {
		
	}
	
	@Test
	public void testGet() {
		
	}
	
	@Test
	public void testModify() {
		
	}
	
	@Test
	public void testDelete() {
		
	}
	
	@Test
	public void testGetList() {
		
	}

}
