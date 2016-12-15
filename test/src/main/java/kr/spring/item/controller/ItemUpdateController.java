package kr.spring.item.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.spring.item.domain.ItemCommand;
import kr.spring.item.service.ItemService;
import kr.spring.util.FileUtil;

@Controller
@SessionAttributes("command")
public class ItemUpdateController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private ItemService itemService;
	
	@RequestMapping(value="/item/update.do", method=RequestMethod.GET)
	public String form(@RequestParam("it_num")int it_num, Model model, HttpSession session){
		String id = (String)session.getAttribute("userId");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("it_num", it_num);
		
		ItemCommand	itemCommand = itemService.selectItem(it_num);
		itemCommand.setMem_id(id);
		model.addAttribute("command", itemCommand);
		
		return "itemModify";
	}
	@RequestMapping(value="/item/update.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid ItemCommand itemCommand, BindingResult result, SessionStatus status, HttpSession session)throws Exception{
		if(log.isDebugEnabled()){
			log.debug("itemCommand : " + itemCommand);
		}
		
		String userId = (String)session.getAttribute("userId");
		if(!userId.equals(itemCommand.getMem_id())){
			throw new Exception("로그인 한 아이디로 작성된 글이 아닙니다.");
		}
		if(result.hasErrors()){
			return "itemModify";
		}
	
		itemService.update(itemCommand);
		status.setComplete();
		
		return "redirect:/item/list.do";
	}
}
