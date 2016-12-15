package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.member.service.MemberService;
import kr.spring.point.domain.PointCommand;

@Controller
@SessionAttributes("command")
public class pointController {

	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private MemberService memberService;

	@RequestMapping(value="/member/point.do", method = RequestMethod.GET)
	public ModelAndView form(HttpSession session){
		String mem_id = (String)session.getAttribute("userId");

		PointCommand point = memberService.selectPoint(mem_id);

		return new ModelAndView("point", "point", point);
	}

	@RequestMapping(value="/member/addPoint.do", method = RequestMethod.POST)
	public String submit(@Valid PointCommand pointCommand, SessionStatus status) throws Exception{
		if(log.isDebugEnabled()){
			log.debug("PointCommand : " + pointCommand);
		}
		//포인트 충전
		memberService.addPoint(pointCommand);
		status.setComplete();

		return "redirect:/member/detail.do";
	}
	@RequestMapping(value = "/member/refundPoint.do", method = RequestMethod.POST)
	public String refundSubmit(@Valid PointCommand pointCommand, SessionStatus status) throws Exception{
		if(log.isDebugEnabled()){
			log.debug("PointCommand : " + pointCommand);
		}
		//포인트 삭감
		memberService.refundPoint(pointCommand);
		
		status.setComplete();
		
		return "redirect:/member/detail.do";
	}
}
