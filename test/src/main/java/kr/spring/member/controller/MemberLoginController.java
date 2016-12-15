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

@Controller
public class MemberLoginController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping(value="/member/login.do", method=RequestMethod.GET)
	public String form() {
		return "Login";
	}
	
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid MemberCommand memberCommand, BindingResult result, HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("memberCommand : " + memberCommand);
		}
		if(result.hasFieldErrors("mem_id") || result.hasFieldErrors("mem_passwd")) {
			return form();
		}
		try {
			MemberCommand member = memberService.selectMember(memberCommand.getMem_id());
			boolean check = false;
			if(member!=null) {
				check = member.isCheckedPasswd(memberCommand.getMem_passwd());
			}
			
			if(check) {
				session.setAttribute("userId", memberCommand.getMem_id());
				if(memberCommand.getMem_id().equals("admin")) {
					return "redirect:../admin/main.do";
				} else {
					return "redirect:../main/main.do";
				}
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			result.reject("invalidIdOrPassword");
			return form();
		}
	}

}
