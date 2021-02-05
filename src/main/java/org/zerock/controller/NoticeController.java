package org.zerock.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.MemberVO;
import org.zerock.domain.NoticeVO;
import org.zerock.service.NoticeService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor// 필드 주입
@RequestMapping("/notice/*")
public class NoticeController {

	private NoticeService service;
	
	@GetMapping("/register")
	@RequestMapping("/register")
	public void register(HttpServletRequest req) {
		// /notice/register.jsp
		
		MemberVO member = new MemberVO();
		member.setNo(1);
		member.setName("hong");
		
		HttpSession session = req.getSession();
		session.setAttribute("user", member);
	}
	
	@PostMapping("/register")
	public String register(NoticeVO notice) {
		// spring이 request.getParameter() 처리
		service.register(notice);
		return "redirec:/notice/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(Long no, Model model) {
		NoticeVO notice = service.get(no);
		model.addAttribute("notice", notice);
		// /notice/get.jsp | /notice/modify.jsp
	}
	
	@PostMapping("/modify")
	public String modify(NoticeVO notice, RedirectAttributes rttr) {
		if (service.modify(notice)) {
			rttr.addAttribute("result", "modSuccess");
		}
		return "redirec:/notice/get";// param -> no지정		
	}
	
	@PostMapping("/delete")
	public String delete(Long no, RedirectAttributes rttr) {
		if (service.delete(no)) {
			rttr.addAttribute("result", "delSuccess");
		}
		return "redirect:/notice/list";
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		int total = service.getTotal();// pageDTO에 사용 !!!!!!!
		
		List<NoticeVO> list = service.getList();
		model.addAttribute("list", list);// disaptcherServlet이 모델 관리, jsp한테 넘겨줌
	}
	
}
