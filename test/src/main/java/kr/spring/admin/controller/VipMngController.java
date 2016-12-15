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

import kr.spring.buy.domain.BuyCommand;
import kr.spring.buy.service.BuyService;
import kr.spring.item.domain.ItemCommand;
import kr.spring.item.service.ItemService;
import kr.spring.util.PagingUtil;

@Controller
public class VipMngController {
	
	private int rowCount = 5;
	private int pageCount = 1;
	
	@Resource
	private ItemService itemService;
	
	@Resource
	private BuyService buyService;
	
	@RequestMapping("/admin/vipmng.do")
	public ModelAndView process(){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("vipmng");
		return mav;
	}
	
	@RequestMapping("/admin/vipbuy.do")
	@ResponseBody
	public Map<String,Object> buy(@RequestParam(value="pageNum",defaultValue="1") int currentPage){
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		int vipBuyCount = buyService.getVipBuyCount(map);
		
		PagingUtil page = new PagingUtil(currentPage, vipBuyCount, rowCount, pageCount, "vipbuy.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<BuyCommand> vipBuyList = null;
		if(vipBuyCount > 0){
			vipBuyList = buyService.vipBuyList(map);
		}else{
			vipBuyList = Collections.emptyList();
		}
		
		Map<String,Object> mapJson = new HashMap<String,Object>();
		mapJson.put("vipBuyCount", vipBuyCount);
		mapJson.put("rowCount", rowCount);
		mapJson.put("pageCount", pageCount);
		mapJson.put("vipBuyList", vipBuyList);
		
		return mapJson;
	}
	
	@RequestMapping("/admin/vipsell.do")
	@ResponseBody
	public Map<String,Object> sell(@RequestParam(value="pageNum",defaultValue="1") int currentPage){
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		int vipSellCount = itemService.getVipSellCount(map);
		
		PagingUtil page = new PagingUtil(currentPage, vipSellCount, rowCount, pageCount, "vipsell.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<ItemCommand> vipSellList = null;
		if(vipSellCount > 0){
			vipSellList = itemService.vipSellList(map);
		}else{
			vipSellList = Collections.emptyList();
		}
		
		Map<String,Object> mapJson = new HashMap<String,Object>();
		mapJson.put("vipSellCount", vipSellCount);
		mapJson.put("rowCount", rowCount);
		mapJson.put("pageCount", pageCount);
		mapJson.put("vipSellList", vipSellList);
		
		return mapJson;
	}
	

}
