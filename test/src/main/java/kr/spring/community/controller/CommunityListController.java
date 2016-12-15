package kr.spring.community.controller;

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
import kr.spring.util.PagingUtil;

@Controller
public class CommunityListController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 8;
	private int pageCount = 5;
	
	@Resource
	private CommunityService communityService;
	
	@RequestMapping("/community/list.do")
	public ModelAndView mainList(@RequestParam(value="pageNum", defaultValue="1") int currentPage, @RequestParam(value="keyfield", defaultValue="") String keyfield, @RequestParam(value="keyword", defaultValue="") String keyword) {
		if(log.isDebugEnabled()) {
			log.debug("pageNum : " + currentPage);
			log.debug("keyfield : " + keyfield);
			log.debug("keyword : " + keyword);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("keyfield", keyfield); 
		map.put("keyword", keyword);
		
		//전체 게시글 수 & 검색된 게시글 수
		int count = communityService.getRowCount(map);
		
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count, rowCount, pageCount, "list.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<CommunityCommand> list = null;
		if(count>0) {
			list = communityService.list(map);
		} else {
			list = Collections.emptyList();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("communityList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		return mav;
	}
	
}
