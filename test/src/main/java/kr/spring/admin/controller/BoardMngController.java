package kr.spring.admin.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.faq.domain.FaqCommand;
import kr.spring.faq.service.FaqService;
import kr.spring.notice.domain.NoticeCommand;
import kr.spring.notice.service.NoticeService;
import kr.spring.util.PagingUtil;

@Controller
public class BoardMngController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 10;
	private int pageCount = 10;
	
	@Resource(name="faqService")
	private FaqService faqService;
	@Resource(name="noticeService")
	private NoticeService noticeService;
	
	@RequestMapping("/admin/boardmng.do")
	public ModelAndView process(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		int faqCount = faqService.getRowCount(map);
		int noticeCount = noticeService.getRowCount(map);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("boardmng");
		mav.addObject("faqCount", faqCount);
		mav.addObject("noticeCount", noticeCount);
		return mav;
	}
	
	@RequestMapping("/admin/faqAjax.do")
	@ResponseBody
	public Map<String, Object> faqList(@RequestParam(value="pageNum", defaultValue="1") int currentPage) {
		if(log.isDebugEnabled()) {
			log.debug("pageNum : " +currentPage);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int count = faqService.getRowCount(map);
		
		PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount, "faqAjax.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<FaqCommand> faqList = null;
		if(count>0) {
			faqList = faqService.list(map);
		} else {
			faqList = Collections.emptyList();
		}

		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("pageCount", pageCount);
		mapJson.put("faqList", faqList);
		
		return mapJson;
		
	}
	
	@RequestMapping("/admin/noticeAjax.do")
	@ResponseBody
	public Map<String, Object> noticeList(@RequestParam(value="pageNum", defaultValue="1") int currentPage) {
		if(log.isDebugEnabled()) {
			log.debug("pageNum : " +currentPage);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		int count = noticeService.getRowCount(map);
		
		PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount, "noticeAjax.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<NoticeCommand> noticeList = null;
		if(count>0) {
			noticeList = noticeService.list(map);
		} else {
			noticeList = Collections.emptyList();
		}
		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("pageCount", pageCount);
		mapJson.put("noticeList", noticeList);
		
		return mapJson;
		
	}
	
}
