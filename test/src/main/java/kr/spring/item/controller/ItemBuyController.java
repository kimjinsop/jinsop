package kr.spring.item.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.buy.domain.BuyCommand;
import kr.spring.buy.service.BuyService;
import kr.spring.item.domain.ItemCommand;
import kr.spring.item.service.ItemService;

import kr.spring.member.service.MemberService;
import kr.spring.point.domain.PointCommand;

@Controller
@SessionAttributes("command")
public class ItemBuyController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private ItemService itemService;
	@Resource
	private MemberService memberService;
	@Resource
	private BuyService buySerivce;

	@RequestMapping(value="/item/buy.do", method = RequestMethod.GET)
	public ModelAndView form(@RequestParam("it_num") int it_num, HttpSession session, HttpServletRequest request){
		if(log.isDebugEnabled()){
			log.debug("it_num : " + it_num);
		}

		String mem_id = (String)session.getAttribute("userId");

		ItemCommand item = itemService.selectItem(it_num);
		PointCommand point = memberService.selectPoint(mem_id);
		ItemCommand itemCommand = itemService.selectItem(it_num);

		
		if(mem_id.equals(itemCommand.getMem_id())){
			return new ModelAndView("main");
		}
		if(item.getIt_status().equals("C") || item.getIt_status().equals("N")){
			return new ModelAndView("main");
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("itemBuy");
		mav.addObject("item", item);
		mav.addObject("point", point);

		return mav;
	}

	@RequestMapping(value="/item/buy.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute("itemBuy") @Valid BuyCommand buyCommand, BindingResult result, SessionStatus status, HttpServletRequest request, HttpSession session) throws Exception{
		if(log.isDebugEnabled()){
			log.debug("buyCommand : " + buyCommand);
		}
		
		if(result.hasErrors()){
			return "itemBuy";
		}
		
		int it_num = Integer.parseInt(request.getParameter("it_num"));
		String mem_id = (String)session.getAttribute("userId");
		ItemCommand itemCommand = itemService.selectItem(it_num);
		
		if(mem_id.equals(itemCommand.getMem_id())){
			throw new Exception("자신이 올린 상품은 자신이 구매할 수 없습니다.");
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("it_num", it_num);
		map.put("mem_id", mem_id);
		
		//구매
		buySerivce.insert(buyCommand);
		//구매자 마일리지 차감
		buySerivce.UpdateBuyerPoint(map);
		//판매자 마일리지 상승
		buySerivce.UpdateSellerPoint(buyCommand.getIt_num());
		//상품이 팔릴 시 스테이터스 변화
		itemService.updateStatus(buyCommand.getIt_num());
		status.setComplete();

		return "redirect:/member/receipts.do";
	}
}