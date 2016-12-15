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
import kr.spring.community.service.CommunityService;
import kr.spring.item.domain.ItemCommand;
import kr.spring.item.service.ItemService;
import kr.spring.member.service.MemberService;
import kr.spring.util.PagingUtil;

@Controller
public class AdminMainController {

	
	private int rowCount = 10;
	private int pageCount = 1;
	
	@Resource
	private CommunityService communityService;
	@Resource
	private MemberService  memberService;
	@Resource
	private ItemService itemService;

	@Resource
	private BuyService buyService;
	
	@RequestMapping("/admin/main.do")
	public ModelAndView main() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int community = communityService.getRowCount(map);
		int member  = memberService.getRowCount(map);
		int sell = itemService.getSellCount(map);
		int buy = itemService.getSoldCount(map);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminMain");
		mav.addObject("community", community);
		mav.addObject("member", member);
		mav.addObject("sell", sell);
		mav.addObject("buy", buy);
		return mav;
	}
	
	//±¸¸Å
		@RequestMapping("/admin/mainvipbuy.do")
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
		
		@RequestMapping("/admin/mainvipsell.do")
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
