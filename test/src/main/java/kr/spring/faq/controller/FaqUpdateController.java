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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.spring.faq.domain.FaqCommand;
import kr.spring.faq.service.FaqService;

@Controller
@SessionAttributes("command")
public class FaqUpdateController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private FaqService faqService;
	
	@RequestMapping(value="/faq/update.do", method=RequestMethod.GET)
	public String form(@RequestParam("faq_num") int faq_num, Model model) {
		FaqCommand faqCommand = faqService.selectFaq(faq_num);
		model.addAttribute("command", faqCommand);
		return "faqUpdate";
	}
	
	@RequestMapping(value="/faq/update.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid FaqCommand faqCommand, BindingResult result, SessionStatus status, HttpSession session) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("faqCommand : " + faqCommand);
		}
		if(result.hasErrors()) {
			return "faqModify";
		}
		
		faqService.update(faqCommand);
		status.setComplete();
		
		return "redirect:../admin/boardmng.do";
	}
	
}
