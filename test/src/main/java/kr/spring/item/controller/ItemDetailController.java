package kr.spring.item.controller;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.item.domain.ItemCommand;
import kr.spring.item.service.ItemService;

@Controller
public class ItemDetailController {
	
	private Logger log = Logger.getLogger(getClass());
	
	@Resource(name="itemService")
	private ItemService itemService;
	
	@RequestMapping("/item/detail.do")
	public ModelAndView process(@RequestParam("it_num") int it_num){
		ItemCommand itemCommand = itemService.selectItem(it_num);
		
		if(log.isDebugEnabled()){
			log.debug("it_num : " + it_num);
		}
		if(itemCommand.getIt_status().equals("C") || itemCommand.getIt_status().equals("N")){
			return new ModelAndView("main");
		}
		
		ItemCommand item = itemService.selectItem(it_num);
	
		return new ModelAndView("itemDetail", "item", item);
	}
	  
}
