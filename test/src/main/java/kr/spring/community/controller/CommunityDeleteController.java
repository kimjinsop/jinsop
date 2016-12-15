package kr.spring.community.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.community.domain.CommunityCommand;
import kr.spring.community.service.CommunityService;
import kr.spring.util.FileUtil;

@Controller
public class CommunityDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private CommunityService communityService;
	
	@RequestMapping("/community/delete.do")
	public String submit(@RequestParam("cm_num") int cm_num, HttpSession session) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("cm_num : " + cm_num);
		}
		CommunityCommand communityCommand = communityService.selectCommunity(cm_num);
		String userId = (String)session.getAttribute("userId");
		if(!userId.equals(communityCommand.getMem_id())) {
			throw new Exception(userId + "님이 작성한 글이 아닙니다.");
		}
		communityService.delete(cm_num);
		if(communityCommand.getCm_image()!=null) {
			FileUtil.removeFile(communityCommand.getCm_image());
		}
		
		return "redirect:/community/list.do";
	}

}
