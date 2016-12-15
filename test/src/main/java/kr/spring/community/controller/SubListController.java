package kr.spring.community.controller;

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

import kr.spring.community.domain.CommunityCommand;
import kr.spring.community.service.CommunityService;
import kr.spring.util.PagingUtil;

@Controller
public class SubListController {
	
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 5;
	private int pageCount = 1;
	
	@Resource
	private CommunityService communityService;
		
	@RequestMapping("/community/listAjax.do")
	@ResponseBody
	public Map<String, Object> subList (@RequestParam(value="pageNum", defaultValue="1") int currentPage, @RequestParam(value="keyfield", defaultValue="") String keyfield, @RequestParam(value="keyword", defaultValue="") String keyword) {
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
		
		PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount, "listAjax.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<CommunityCommand> list = null;
		if(count>0) {
			list = communityService.list(map);
		} else {
			list = Collections.emptyList();
		}
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("pageCount", pageCount);
		mapJson.put("list", list);
		
		return mapJson;
	}

}
