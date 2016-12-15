
package kr.spring.admin.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.item.domain.ItemCommand;
import kr.spring.item.service.ItemService;
import kr.spring.util.PagingUtil;

@Controller
public class SellTotalMngController{
	private int rowCount = 10;
	private int pageCount = 10;

	@Resource
	private ItemService itemService;

	@RequestMapping("/admin/selltotalmng.do")	
	public ModelAndView process(){

		ModelAndView mav = new ModelAndView();
		mav.setViewName("selltotalmng");

		return mav;
	}		

	@RequestMapping("/admin/sellmng.do")
	@ResponseBody
	public Map<String,Object> sell(@RequestParam(value="pageNum",defaultValue="1") int currentPage){		

		//HASHMAP
		HashMap<String,Object> map = new HashMap<String,Object>();

		//총 회원 수 또는 검색된 글의 개수 구함
		int sellCount = itemService.getSellCount(map);

		PagingUtil page = new PagingUtil(currentPage, sellCount, rowCount, pageCount, "sellmng.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<ItemCommand> sellList = null;
		if(sellCount > 0){
			sellList = itemService.sellList(map);
		}else{
			sellList = Collections.emptyList();
		}

		Map<String,Object> mapJson = new HashMap<String,Object>();
		mapJson.put("sellCount", sellCount);
		mapJson.put("rowCount", rowCount);
		mapJson.put("pageCount", pageCount);
		mapJson.put("sellList", sellList);

		return mapJson;
	}

	@RequestMapping("/admin/sellingmng.do")
	@ResponseBody
	public Map<String,Object> selling(@RequestParam(value="pageNum",defaultValue="1")	int currentPage){		

		//HASHMAP
		HashMap<String,Object> map = new HashMap<String,Object>();

		//총 회원 수 또는 검색된 글의 개수 구함
		int sellingCount = itemService.getSellingCount(map);

		PagingUtil page = new PagingUtil(currentPage, sellingCount, rowCount, pageCount, "sellingmng.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<ItemCommand> sellingList = null;
		if(sellingCount > 0){
			sellingList = itemService.sellingList(map);
		}else{
			sellingList = Collections.emptyList();
		}

		Map<String,Object> mapJson = new HashMap<String,Object>();
		mapJson.put("sellingCount", sellingCount);
		mapJson.put("rowCount", rowCount);
		mapJson.put("pageCount", pageCount);
		mapJson.put("sellingList", sellingList);

		return mapJson;
	}

	@RequestMapping("/admin/soldmng.do")
	@ResponseBody
	public Map<String,Object> sold(@RequestParam(value="pageNum",defaultValue="1")	int currentPage){		

		//HASHMAP
		HashMap<String,Object> map = new HashMap<String,Object>();

		//총 회원 수 또는 검색된 글의 개수 구함
		int soldCount = itemService.getSoldCount(map);

		PagingUtil page = new PagingUtil(currentPage, soldCount, rowCount, pageCount, "soldmng.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<ItemCommand> soldList = null;
		if(soldCount > 0){
			soldList = itemService.soldList(map);
		}else{
			soldList = Collections.emptyList();
		}

		Map<String,Object> mapJson = new HashMap<String,Object>();
		mapJson.put("soldCount", soldCount);
		mapJson.put("rowCount", rowCount);
		mapJson.put("pageCount", pageCount);
		mapJson.put("soldList", soldList);

		return mapJson;
	}

	//판매 신청 - > 판매 진행 처리
	@RequestMapping("/admin/sellAgree.do")
	@ResponseBody
	public Map<String, Object> sellAgree(ItemCommand itemCommand) {
	
		List<Integer> it_num = itemCommand.getYes();
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			itemService.sellAgree(it_num);
			map.put("result", "success");			
		} catch(Exception e){
			e.printStackTrace();
			map.put("result", "failure");
		}			
		return map;
	}

}
