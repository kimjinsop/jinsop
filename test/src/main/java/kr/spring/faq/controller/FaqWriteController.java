package kr.spring.faq.controller;

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

import kr.spring.faq.domain.FaqCommand;
import kr.spring.faq.service.FaqService;

@Controller
@SessionAttributes("command")
public class FaqWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private FaqService faqService;
	
	@RequestMapping(value="/faq/write.do", method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {
		String mem_id = (String)session.getAttribute("userId");
		
		FaqCommand command = new FaqCommand();
		command.setMem_id(mem_id);
		model.addAttribute("command", command);
		
		return "faqWrite";
	}
	
	@RequestMapping(value="/faq/write.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid FaqCommand faqCommand, BindingResult result, SessionStatus status) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("faqCommand : " + faqCommand);
		}
		faqService.insert(faqCommand);
		status.setComplete();
		
		return "redirect:../admin/boardmng.do";
	}
	
	
}
