package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.NCriteria;
import org.zerock.domain.NPageDTO;
import org.zerock.domain.NoticeVO;
import org.zerock.service.NoticeService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor// 필드 주입
@RequestMapping("/notice/*")
public class NoticeController {

	private NoticeService service;
	
	/*
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
	*/
	
	@GetMapping("/register")
	public void register() {
		// /notice/register.jsp
	}
	
	@PostMapping("/register")// 시간 여기 기준으로 못하나 ???????????222222
	public String register(NoticeVO notice) {// (category), title, content
		// spring이 request.getParameter() 처리
		service.register(notice);
		return "redirect:/notice/list";
	}
	
	@GetMapping("/get")
	public void getWithCnt(Long no, Model model) {// 뒤로가기하면 조회수 안 늘어남!!!!!!!!!!1 111111
		NoticeVO notice = service.getWithCnt(no);
		model.addAttribute("notice", notice);
		// /notice/get.jsp
	}
	
	@GetMapping("/modify")
	public void get(Long no, Model model) {
		NoticeVO notice = service.get(no);
		model.addAttribute("notice", notice);
		// /notice/modify.jsp
	}
	
	@PostMapping("/modify")
	public String modify(NoticeVO notice, RedirectAttributes rttr) {
		if (service.modify(notice)) {
			rttr.addFlashAttribute("result", "modSuccess");// parameter로 붙음
		}
		rttr.addAttribute("no", notice.getNo());
		return "redirect:/notice/get";// param -> no지정		
	}
	
	@PostMapping("/delete")
	public String delete(Long no, RedirectAttributes rttr) {
		if (service.delete(no)) {
			rttr.addFlashAttribute("result", "delSuccess");
		}
		return "redirect:/notice/list";
	}
	
	@GetMapping("/list")
	public void list(Model model, @ModelAttribute("cri") NCriteria cri) {// cri -> setter()		
		List<NoticeVO> list = service.getList(cri);// amount: 10개씩만 갖고 오기
		model.addAttribute("list", list);// disaptcherServlet이 모델 관리, jsp한테 넘겨줌
		
		int total = service.getTotal();
		model.addAttribute("pages", new NPageDTO(total, cri));
	}
	
}
