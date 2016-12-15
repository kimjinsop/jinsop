package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;
import kr.spring.point.domain.PointCommand;

@Controller
public class MemberWriteController {
	private Logger log = Logger.getLogger(this.getClass());

	@Resource
	private MemberService memberService;
	
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping(value="/member/write.do", method=RequestMethod.GET)
	public String form() {
		return "register";
	}
	
	@RequestMapping(value="/member/write.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid MemberCommand memberCommand, BindingResult result, HttpSession session, PointCommand point) {
		if(log.isDebugEnabled()) {
			log.debug("memberCommand : " + memberCommand);
		}
		if(result.hasErrors()) {
			return form();
		}
		memberService.insert(memberCommand);
		memberService.insertPoint(point);
		
		session.setAttribute("userId", memberCommand.getMem_id());
		
		return "redirect:/main/main.do";
	}
	
}
