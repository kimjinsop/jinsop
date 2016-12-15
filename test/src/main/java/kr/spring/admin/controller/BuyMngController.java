package kr.spring.admin.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.buy.domain.BuyCommand;
import kr.spring.buy.service.BuyService;
import kr.spring.item.service.ItemService;
import kr.spring.util.PagingUtil;

@Controller
public class BuyMngController {
	
	private int rowCount = 10;
	private int pageCount  = 10;
	
	@Resource
	private BuyService buyService;
	
	@Resource
	private ItemService itemService;
	
	@RequestMapping("/admin/buymng.do")
	public ModelAndView buy(@RequestParam(value="pageNum",defaultValue="1")
	int currentPage){
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		int count = buyService.getbuyCount(map);
		
		PagingUtil page = new PagingUtil(currentPage,count,rowCount,pageCount,"buymng.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<BuyCommand> list = null;
		if(count > 0){
			list = buyService.buyList(map);
		}else{
			list = Collections.emptyList();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("buymng");
		mav.addObject("buyCount", count);
		mav.addObject("buyList", list);
		mav.addObject("pagingHtml", page.getPagingHtml());
		
		return mav;
	}
	
}
