package kr.spring.admin.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.community.domain.CommunityCommand;
import kr.spring.community.service.CommunityService;
import kr.spring.util.FileUtil;
import kr.spring.util.PagingUtil;

@Controller
public class CommMngController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private CommunityService communityService;
	
	@RequestMapping("/admin/list.do")
	public ModelAndView mainList(@RequestParam(value="pageNum", defaultValue="1") int currentPage) {
		if(log.isDebugEnabled()) {
			log.debug("pageNum : " + currentPage);
		}
		int rowCount = 6;
		int pageCount = 10;
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		//전체 게시글 수 & 검색된 게시글 수
		int count = communityService.getRowCount(map);
		
		PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount, "list.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<CommunityCommand> list = null;
		if(count>0) {
			list = communityService.list(map);
		} else {
			list = Collections.emptyList();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("commmng");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		return mav;
	}
	
	@RequestMapping("/admin/view.do")
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
		mav.setViewName("commViewMng");
		mav.addObject("cm_reply", cm_reply);
		mav.addObject("community", community);
		return mav;
	}

	@RequestMapping("/admin/delete.do")
	public String delete(@RequestParam("cm_num") int cm_num) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("cm_num : " + cm_num);
		}
		CommunityCommand communityCommand = communityService.selectCommunity(cm_num);
	
		communityService.delete(cm_num);
		if(communityCommand.getCm_image()!=null) {
			FileUtil.removeFile(communityCommand.getCm_image());
		}
		
		return "redirect:/admin/list.do";
	}
}
