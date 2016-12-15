package kr.spring.member.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.buy.domain.BuyCommand;
import kr.spring.buy.service.BuyService;
import kr.spring.item.domain.ItemCommand;
import kr.spring.item.service.ItemService;
import kr.spring.util.PagingUtil;

@Controller
public class MemberReceiptsController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 5;
	private int pageCount = 5;

	@Resource
	private BuyService buyService;
	@Resource
	private ItemService itemService;

	@RequestMapping("/member/receipts.do")
	public String process(){
		return "receipts";
	}

	@RequestMapping("/member/buyAjax.do")
	@ResponseBody
	public Map<String, Object> buyList(@RequestParam(value="pageNum", defaultValue="1") int currentPage, HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("pageNum : " + currentPage);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		String mem_id = (String)session.getAttribute("userId");
		map.put("mem_id", mem_id);

		int count = buyService.getRowCount(map);

		PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount, "buyAjax.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<BuyCommand> buyList = null;
		if(count>0) {
			buyList = buyService.list(map);
		} else {
			buyList = Collections.emptyList();
		}

		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("pageCount", pageCount);
		mapJson.put("buyList", buyList);
		return mapJson;
	}
	
	@RequestMapping("/member/sellAjax.do")
	@ResponseBody
	public Map<String, Object> sellList(@RequestParam(value="pageNum", defaultValue="1") int currentPage, HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("pageNum : " + currentPage);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		String mem_id = (String)session.getAttribute("userId");
		map.put("mem_id", mem_id);

		int sellCount = itemService.getUserSellCount(map);

		PagingUtil page = new PagingUtil(currentPage, sellCount, rowCount, pageCount, "sellAjax.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<ItemCommand> sellList = null;
		if(sellCount>0) {
			sellList = itemService.userSellList(map);
		} else {
			sellList = Collections.emptyList();
		}

		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("sellCount", sellCount);
		mapJson.put("rowCount", rowCount);
		mapJson.put("pageCount", pageCount);
		mapJson.put("sellList", sellList);
		return mapJson;
	}
	
	@RequestMapping("/member/sellingAjax.do")
	@ResponseBody
	public Map<String, Object> sellingList(@RequestParam(value="pageNum", defaultValue="1") int currentPage, HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("pageNum : " + currentPage);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		String mem_id = (String)session.getAttribute("userId");
		map.put("mem_id", mem_id);

		int sellingCount = itemService.getUserSellingCount(map);

		PagingUtil page = new PagingUtil(currentPage, sellingCount, rowCount, pageCount, "sellingAjax.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<ItemCommand> sellingList = null;
		if(sellingCount>0) {
			sellingList = itemService.userSellingList(map);
		} else {
			sellingList = Collections.emptyList();
		}

		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("sellingCount", sellingCount);
		mapJson.put("rowCount", rowCount);
		mapJson.put("pageCount", pageCount);
		mapJson.put("sellingList", sellingList);
		return mapJson;
	}
	
	@RequestMapping("/member/soldAjax.do")
	@ResponseBody
	public Map<String, Object> soldList(@RequestParam(value="pageNum", defaultValue="1") int currentPage, HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("pageNum : " + currentPage);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		String mem_id = (String)session.getAttribute("userId");
		map.put("mem_id", mem_id);

		int soldCount = itemService.getUserSoldCount(map);

		PagingUtil page = new PagingUtil(currentPage, soldCount, rowCount, pageCount, "soldAjax.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());

		List<ItemCommand> soldList = null;
		if(soldCount>0) {
			soldList = itemService.userSoldList(map);
		} else {
			soldList = Collections.emptyList();
		}

		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("soldCount", soldCount);
		mapJson.put("rowCount", rowCount);
		mapJson.put("pageCount", pageCount);
		mapJson.put("soldList", soldList);
		return mapJson;
	}
}
