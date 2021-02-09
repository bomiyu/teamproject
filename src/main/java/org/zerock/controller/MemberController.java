package org.zerock.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.MemberVO;
import org.zerock.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@RequestMapping("/member/*")
@Log4j
public class MemberController {

	private MemberService service;

	// ##회원가입 - GET
	@GetMapping("/join")
	public void register() {
		// get형식으로는 모르겠당!
	}

	// ##회원가입 - POST
	@PostMapping("/join")
	public String register(MemberVO member, HttpServletRequest req) {
		
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		validate(errors, member);
		
		if (errors.isEmpty()) {
			service.register(member);
			// 서비스에 일을 시키고
			return "redirect:joinSuccess";
			

		} else {
			return "/member/join";
		}
		
	}
	// ##로그인 성공 메시지
	@GetMapping("/joinSuccess")
	public void joinSuccess() {
	}

	// ##로그인 - GET
	@GetMapping("/login")
	public void login() {
	}

	// ##로그인 - POST
	@PostMapping("/login")
	public String login(MemberVO member, HttpSession session) {
		
		MemberVO user = service.getMember(member.getId());
		
			//사용자의 아이디를 가진 회원이 있다면
			if(user != null && member.getPassword() != null) {
				// member.getPassword(); 사용자가 적은 비밀번호
				// loginMember.getPassword(); 아이디로 검색해서 꺼낸 회원의 비밀번호
				// 이 부분 간단하게 하고싶은데!
			
				if(member.getPassword().equals(user.getPassword())) {
					
					
			//RedirectAttributes rttr;
			//		rttr.addAttribute("authUser", user);
			
			//		HttpServletRequest req
			//	req.getSession().setAttribute("authUser", user);
					
					session.setAttribute("authUser", user);
					//세션에 정보 담기
	
					
					return "redirect:/index.jsp";
				}
		
			}
			return "";
	}
	
	
	// ##로그아웃 
	@GetMapping("/logout")
	public String logout(MemberVO member, HttpSession session) {
		
		if(session != null) {
			session.invalidate();
		}
		
		return "redirect:/index.jsp";
	}
	//로그아웃 post 방식은?? 왜 겟방식이지
	
	// ##joinErrors 
	public void validate(Map<String, Boolean> errors, MemberVO member) {
		checkEmpty(errors, member.getId(), "memberId");
		checkEmpty(errors, member.getPassword(), "memberPw");
		checkEmpty(errors, member.getPwConfirm(), "memberPwConfirm");
		checkEmpty(errors, member.getEmail(), "memberEmail");
		checkEmpty(errors, member.getName(), "memberName");
		checkEmpty(errors, member.getNickname(), "memberNickname");
		checkEmpty(errors, member.getLoc(), "memberLoc");
		//checkEmpty 메소드로 데이터가 비어있는 지 확인. 단, manager 데이터는 제외
		
		if(member.getPwConfirm() != null && !member.getPassword().equals(member.getPwConfirm())) {
			errors.put("pwNotMatch", true);
		}
	}
	
	public void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		
		if(value == null || value.isEmpty()) {
			errors.put(fieldName, true);
		}
	}
	
	
	// ##내정보 보기
	@GetMapping("/myHome")
	public String myhome() {
		return "/member/myHome";
		//redirect는 왜 안되지?
		//왜 무한로프가 도는 거지?
	}
	
	// ##내정보 수정
	@GetMapping("/myModify")
	public String myModify(MemberVO member) {
		service.modify(member);
		return "/member/myModify";
	}
	
	
	
}