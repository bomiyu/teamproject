package org.zerock.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.FreeBoardVO;
import org.zerock.domain.MemberVO;
import org.zerock.service.FreeBoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@RequestMapping("/freeboard/*")
@Log4j
public class FreeBoardController {
	
	private FreeBoardService service;

//	public BoardController(FreeBoardService service) {
//		super();
//		this.service = service;
//	}
	


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@GetMapping("/list") 
	
	public void list(Model model) {
		log.info("******************** list *******************");
		List<FreeBoardVO> list = service.getList();
		model.addAttribute("list", list);
	}
	
	
	
	
//	@GetMapping("/list")
//	public void list(@ModelAttribute("cri") Criteria cri, Model model) {
//		List<FreeBoardVO> list = service.getList(cri);
//		
//		int total = service.getTotal(cri);
//		
//		PageDTO dto = new PageDTO(cri, total);
//		
//		model.addAttribute("list", list);
//		model.addAttribute("pageMaker", dto);
//	}
	@GetMapping("/register")
	   @RequestMapping("/register")
	   public void register(HttpServletRequest req) {
	      // /freeboard/register.jsp에 session 얻어와서 user라는이름으로 memberVO객체를 SET해줌
	      
	      MemberVO member = new MemberVO();
	      member.setNo(1);
	      member.setName("hong");
	      
	      HttpSession session = req.getSession();
	      session.setAttribute("user", member);
	   }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PostMapping("/register")
	public String register(FreeBoardVO vo, Model model,RedirectAttributes rttr) {

		service.register(vo);
		
		rttr.addFlashAttribute("result", vo.getNo());
		rttr.addFlashAttribute("message", vo.getNo() + "번 글이 등록되었습니다.");
		
//		return "board/list";
		return "redirect:/freeboard/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("no") Long no, Model model) {
		/** 예전 코드 (스프링 없이) 
		String boardNum = request.getParameter("num");
		int num = Integer.parseInt(boardNum);
		
		BoardVO vo = service.get((long) num);
		
		request.setAttribute("board", vo);
		
		request.getRequestDispatcher(".jsp").forward();
		*/
		
		log.info("get method - no: " + no);
//		log.info(cri);
		FreeBoardVO vo = service.get(no);
		model.addAttribute("freeboard", vo);
//		model.addAttribute("cri", cri);
	}

	
	@PostMapping("/modify")
	public String modify(FreeBoardVO vo, RedirectAttributes rttr) {
		/** 스프링 없이
		BoardVO board = new BoardVO();
		board.setBno(request.getParameter("bno"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		*/
		
		if (service.modify(vo)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("message", vo.getNo() + "번 글이 수정되었습니다.");
		}
//		log.info(cri);
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/freeboard/list";
	}

	
	@PostMapping("/remove")
	public String remove(@RequestParam("no") Long no, RedirectAttributes rttr) {
		
		if (service.remove(no)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("message", no + "번 글이 삭제되었습니다.");
		}
		
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/freeboard/list";
	}
	
	
}
