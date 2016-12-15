package kr.spring.notice.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.notice.domain.NoticeCommand;
import kr.spring.notice.service.NoticeService;
import kr.spring.util.PagingUtil;

@Controller
public class NoticeListController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 8;
	private int pageCount = 5;
	
	@Resource
	private NoticeService noticeService;
	
	@RequestMapping("/notice/list.do")
	public ModelAndView process(@RequestParam(value="pageNum", defaultValue="1") int currentPage) {
		if(log.isDebugEnabled()) {
			log.debug("pageNum : " + currentPage);
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int count = noticeService.getRowCount(map);
		
		PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount, "list.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<NoticeCommand> list = null;
		if(count>0) {
			list = noticeService.list(map);
		} else {
			list = Collections.emptyList();
		}		

		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("noticeList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	
	
	
	

}
