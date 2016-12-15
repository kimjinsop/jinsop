package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;
import kr.spring.point.domain.PointCommand;

@Controller
public class MemberDetailController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	@RequestMapping("/member/detail.do")
	public ModelAndView process(HttpSession session) {
		String mem_id = (String)session.getAttribute("userId");
		MemberCommand member = memberService.selectMember(mem_id);
		PointCommand point = memberService.selectPoint(mem_id);
		if(log.isDebugEnabled()){
			log.debug("memberCommand : " + member);
			log.debug("pointCommand : " + point);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("memberView");
		mav.addObject("member", member);
		mav.addObject("point", point);
		
		return mav;
	}
}
