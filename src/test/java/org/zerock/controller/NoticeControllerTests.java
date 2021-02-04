package org.zerock.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.zerock.service.NoticeService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@WebAppConfiguration// disaptcherServlet이 일하도록 명시 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class NoticeControllerTests {

	@Setter(onMethod_ = @Autowired)
	private NoticeService service;
	
	@Test
	public void test() {
		
	}

}
