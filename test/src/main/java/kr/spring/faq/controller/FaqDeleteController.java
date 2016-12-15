package kr.spring.faq.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.faq.service.FaqService;

@Controller
public class FaqDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private FaqService faqService;
	
	@RequestMapping("/faq/delete.do")
	public String submit(@RequestParam("faq_num") int faq_num, HttpSession session) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("faq_num : " + faq_num);
		}
		
		faqService.delete(faq_num);
		
		return "redirect:../admin/boardmng.do";
	}

}
