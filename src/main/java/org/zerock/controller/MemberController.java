package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Controller
@SessionAttributes("user")
@AllArgsConstructor
@RequestMapping("/*")
public class MemberController {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@ModelAttribute("user")
	public MemberVO login() {
		MemberVO user = mapper.read();
		return user;
	}
	
	@ModelAttribute("user")
	public MemberVO doLogin() {
		MemberVO user = mapper.read();
		return user;
	}
	
}
