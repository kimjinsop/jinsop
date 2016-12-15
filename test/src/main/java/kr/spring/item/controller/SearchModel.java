package kr.spring.item.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.item.domain.ModelCommand;
import kr.spring.item.service.ModelService;
import kr.spring.util.PagingUtil;

@Controller
public class SearchModel {
	private int rowCount = 8;
	private int pageCount = 5;
	
	@Resource
	private ModelService modelService;
	
	@RequestMapping("/item/model.do")
	public ModelAndView process(@RequestParam(value="pageNum", defaultValue="1") int currentPage, @RequestParam(value="mo_model", defaultValue="") String mo_model) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("mo_model", mo_model);
		
		int count = modelService.getCount(map);
		
		PagingUtil page = new PagingUtil(null, mo_model, currentPage, count, rowCount, pageCount, "model.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<ModelCommand> list = null;
		if(count>0) {
			list = modelService.list(map);
		} else {
			list = Collections.emptyList();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("search");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
}
