package kr.spring.notice.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.notice.service.NoticeService;

@Controller
public class NoticeDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private NoticeService noticeService;
	
	@RequestMapping("/notice/delete.do")
	public String submit(@RequestParam("nb_num") int nb_num, HttpSession session) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("nb_num : " + nb_num);
		}
		
		noticeService.delete(nb_num);
		
		return "redirect:../admin/boardmng.do";
	
	}

}
