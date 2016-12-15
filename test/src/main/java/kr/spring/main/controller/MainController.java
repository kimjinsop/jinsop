package kr.spring.main.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.item.domain.ItemCommand;
import kr.spring.main.service.MainService;
@Controller
public class MainController {

	
	@Resource
	private MainService mainService;
	
	public String form() {
		return "redirect:/main/main.do";
	}
	
	@RequestMapping("/main/newList.do")
	@ResponseBody
	public Map<String, Object> newList(@RequestParam(value="pageNum", defaultValue="1") int currentPage) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int count = mainService.getnewCount(map);
		
		
		List<ItemCommand> newList = null;
		if(count>0) {
			newList = mainService.newList(map);
		} else {
			newList = Collections.emptyList();
		}
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("count", count);
		mapJson.put("newList", newList);
		
		return mapJson;
		
	}
	
	@RequestMapping("/main/deadList.do")
	@ResponseBody
	public Map<String, Object> deadList(@RequestParam(value="pageNum", defaultValue="1") int currentPage) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int count = mainService.getdeadCount(map);
		
		List<ItemCommand> deadList = null;
		if(count>0) {
			deadList = mainService.deadList(map);
		} else {
			deadList = Collections.emptyList();
		}
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("count",count);
		mapJson.put("deadList",deadList);
		
		return mapJson;
		
	}
	

	@RequestMapping("/main/lowList.do")
	@ResponseBody
	public Map<String, Object> lowList(@RequestParam(value="pageNum", defaultValue="1") int currentPage) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int count = mainService.getlowCount(map);
		
		List<ItemCommand> lowList = null;
		if(count>0) {
			lowList = mainService.lowList(map);
		} else {
			lowList = Collections.emptyList();
		}
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("count",count);
		mapJson.put("lowList",lowList);
		
		return mapJson;
		
	}
	
}