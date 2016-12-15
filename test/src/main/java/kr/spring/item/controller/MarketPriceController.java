package kr.spring.item.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.item.domain.ItemCommand;
import kr.spring.item.service.ItemService;

@Controller
public class MarketPriceController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private ItemService itemService;
	
	@RequestMapping("/item/marketValueAjax.do")
	@ResponseBody
	public Map<String, Object> marketValue(@RequestParam(value="pageNum", defaultValue="1") int currentPage, @RequestParam(value="it_code") String it_code) {
		if(log.isDebugEnabled()) {
			log.debug("pageNum : " + currentPage + ", it_code : " + it_code);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("it_code", it_code);
		
		List<ItemCommand> list = null;
		list = itemService.marketValue(map);

		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("list", list);
		
		return mapJson;
	}

}
