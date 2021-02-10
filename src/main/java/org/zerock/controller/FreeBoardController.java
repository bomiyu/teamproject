package org.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.FCriteria;
import org.zerock.domain.FPageDTO;
import org.zerock.domain.FreeBoardVO;
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

//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	@GetMapping("/list")
//
//	public void list(Model model) {
//		log.info("******************** list *******************");
//		List<FreeBoardVO> list = service.getList();
//		model.addAttribute("list", list);
//	}

	@GetMapping("/list")
	public void list(@ModelAttribute("cri") FCriteria cri, Model model) {
		model.addAttribute("list", service.getList(cri));
		int total = service.getTotal(cri);
		
		log.info("total:::::::::"+ total);
		model.addAttribute("pageMaker", new FPageDTO(cri, total));

	
		
		
	}
	


	@GetMapping("/register")
	@RequestMapping("/register")
	public void register(FreeBoardVO vo) {
	
	}


	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PostMapping("/register")
	public String register(FreeBoardVO vo, Model model, RedirectAttributes rttr, HttpSession session) {
		rttr.addFlashAttribute("result", vo.getNo());
		rttr.addFlashAttribute("message", vo.getNo() + "번 글이 등록되었습니다.");
 //Session에 저장된 nickname을 writer에저장 
		String writer = (String) session.getAttribute("nickname");
		vo.setWriter(writer);
		service.register(vo);
		
		return "redirect:/freeboard/list";
	}

	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("no") Long no, @ModelAttribute("cri") FCriteria cri, Model model) {
		log.info("get method - no: " + no);
		FreeBoardVO vo = service.get(no);
		model.addAttribute("freeboard", vo);
				
		
//		FCriteria cri = new FCriteria();
//		model.addAttribute("cri", cri);
		
//
//		String old_url = request.getHeader("referer");
//		System.out.println(" get, 수정 ======> "+old_url);
	}

	@PostMapping("/modify")
	public String modify(FreeBoardVO vo, @ModelAttribute("cri") FCriteria cri, RedirectAttributes rttr) {
		if (service.modify(vo)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("message", vo.getNo() + "번 글이 수정되었습니다.");
		}

		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());

		return "redirect:/freeboard/list";
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("no") Long no,@ModelAttribute("cri") FCriteria cri, RedirectAttributes rttr) {

		if (service.remove(no)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("message", no + "번 글이 삭제되었습니다.");
		}

		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());

		return "redirect:/freeboard/list";
	}

}
