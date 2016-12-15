package kr.spring.notice.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.spring.notice.domain.NoticeCommand;
import kr.spring.notice.service.NoticeService;

@Controller
@SessionAttributes("command")
public class NoticeWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private NoticeService noticeService;
	
	@RequestMapping(value="/notice/write.do", method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {
		String mem_id = (String)session.getAttribute("userId");
		
		NoticeCommand command = new NoticeCommand();
		command.setMem_id(mem_id);
		model.addAttribute("command", command);
		
		return "noticeWrite";
	}
	
	@RequestMapping(value="/notice/write.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid NoticeCommand noticeCommand, BindingResult result, SessionStatus status) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("noticeCommand : " + noticeCommand);
		}
		noticeService.insert(noticeCommand);
		status.setComplete();
		
		return "redirect:../admin/boardmng.do";
	}
	
	
}
