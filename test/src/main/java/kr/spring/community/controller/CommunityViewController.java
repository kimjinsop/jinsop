package kr.spring.community.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.community.domain.CommunityCommand;
import kr.spring.community.service.CommunityService;

@Controller
public class CommunityViewController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private CommunityService communityService;
	
	@RequestMapping("/community/view.do")
	public ModelAndView process(@RequestParam("cm_num") int cm_num) {
		if(log.isDebugEnabled()) {
			log.debug("cm_num : " + cm_num);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cm_num", cm_num);
		
		communityService.updateHit(cm_num);
		int cm_reply = communityService.getRowCountReply(map);
		CommunityCommand community = communityService.selectCommunity(cm_num);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("communityView");
		mav.addObject("cm_reply", cm_reply);
		mav.addObject("community", community);
		return mav;
	}

}
