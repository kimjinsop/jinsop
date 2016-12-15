package kr.spring.item.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.item.domain.ItemCommand;
import kr.spring.item.service.ItemService;
import kr.spring.util.PagingUtil;

@Controller
@SessionAttributes("command")
public class ItemListController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 8;
	private int pageCount = 1;

	@Resource
	private ItemService itemService;

	@RequestMapping("/item/list.do")
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1") int currentPage, @RequestParam(value="it_model",defaultValue="") String it_model, @RequestParam(value="it_brand", defaultValue="") String it_brand){
		if(log.isDebugEnabled()){
			log.debug("it_brand : " + it_brand);
			log.debug("it_model : " + it_model);
			log.debug("pageNum : " + currentPage);
		}
		System.out.println(it_brand);
		System.out.println(it_model);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("it_brand", it_brand);
		map.put("it_model", it_model);

		//ÃÑ ±ÛÀÇ °¹¼ö ¶Ç´Â °Ë»öµÈ ±ÛÀÇ °¹¼ö
		int count = itemService.getRowCount(map);
		PagingUtil page = new PagingUtil(currentPage, count,	rowCount, pageCount,"list.do", "&it_brand="+it_brand+"&it_model="+it_model);

		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<ItemCommand> list = null;
		if(count > 0){
			list = itemService.list(map);
		}else{
			list = Collections.emptyList();
		}				
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("itemList");
		mav.addObject("count", count);
		mav.addObject("list", list);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}
}


