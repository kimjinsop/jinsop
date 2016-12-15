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
public class ListByModelController {
	private Logger log = Logger.getLogger(this.getClass());

	private int rowCount = 12;
	private int pageCount = 10;

	@Resource(name="itemService")
	private ItemService itemService;

	@RequestMapping("/item/modelList.do") 
	public ModelAndView process(@RequestParam(value="pageNum",defaultValue="1")
								int currentPage,
								@RequestParam("it_code")
	                            String it_code){
		
		if(log.isDebugEnabled()){
			log.debug("pageNum : " + currentPage);
			log.debug("it_code : " + it_code);
		} 

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("it_code", it_code);
		
		//ÃÑ ±ÛÀÇ °¹¼ö ¶Ç´Â °Ë»öµÈ ±ÛÀÇ °¹¼ö
		int count = itemService.getModelCount(map);

		PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount,"modelList.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<ItemCommand> listByModel = null;
		if(count > 0){
			listByModel = itemService.listByModel(map);
		}else{
			listByModel = Collections.emptyList();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("listByModel");
		mav.addObject("count", count);
		mav.addObject("it_code", it_code);
		mav.addObject("listByModel", listByModel);
		mav.addObject("pagingHtml", page.getPagingHtml());

		return mav;
	}
	
}


