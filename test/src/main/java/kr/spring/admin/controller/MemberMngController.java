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

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;
import kr.spring.util.PagingUtil;


@Controller
public class MemberMngController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private int rowCount = 10;
	private int pageCount  = 10;
	
	@Resource
	private MemberService memberService;
	
	@RequestMapping("/admin/membermng.do")
	public ModelAndView process(
			@RequestParam(value="pageNum",defaultValue="1")
			int currentPage,
			@RequestParam(value="keyfield",defaultValue="")
			String keyfield,
			@RequestParam(value="keyword",defaultValue="")
			String keyword){
		
		if(log.isDebugEnabled()){
			log.debug("pageNum : " + currentPage);
			log.debug("keyfield : " + keyfield);
			log.debug("keyword : " + keyword);
		}
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		
		//총 회원 수 또는 검색된 글의 개수 구함
		int count = memberService.getRowCount(map);
		
		PagingUtil page = new PagingUtil(keyfield,keyword,currentPage,count,rowCount,pageCount,"membermng.do");
		
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<MemberCommand> list = null;
		if(count > 0){
			list = memberService.list(map);
		}else{
			list = Collections.emptyList();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("membermng");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	
}
