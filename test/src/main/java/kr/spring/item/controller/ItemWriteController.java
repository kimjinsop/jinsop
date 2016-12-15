package kr.spring.item.controller;

import java.io.File;
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
import kr.spring.item.domain.ModelCommand;
import kr.spring.item.service.ItemService;
import kr.spring.item.service.ModelService;
import kr.spring.util.FileUtil;

@Controller
@SessionAttributes("command")
public class ItemWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private ItemService itemService;
	@Resource
	private ModelService moderService;
	
	@RequestMapping(value="/item/write.do", method = RequestMethod.GET)
	public String form(@RequestParam("mo_code") String mo_code, HttpSession session, Model model){
		String id = (String)session.getAttribute("userId");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("mo_code", mo_code);
				
		ModelCommand modelCommand= moderService.selectModel(mo_code);
		ItemCommand command = new ItemCommand();
		command.setMem_id(id);
		command.setIt_code(modelCommand.getMo_code());
		command.setIt_brand(modelCommand.getMo_brand());
		command.setIt_model(modelCommand.getMo_model());
		model.addAttribute("it_code", mo_code);
		model.addAttribute("command", command);
		
		return "itemWrite";
	}
	
	@RequestMapping(value="/item/write.do", method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid ItemCommand itemCommand, BindingResult result, SessionStatus status) throws Exception{
		if(log.isDebugEnabled()){
			log.debug("itemCommand : " + itemCommand);
		}
		String newName = "";
		
		if(!itemCommand.getUpload().isEmpty()){
			newName = FileUtil.rename(itemCommand.getUpload().getOriginalFilename());
			itemCommand.setIt_image(newName);
		}
		if(result.hasErrors()){
			return "itemWrite";
		}
		//판매등록
		itemService.insert(itemCommand);
		status.setComplete();
		
		//파일을 upload폴더에 저장
		if(!itemCommand.getUpload().isEmpty()){
			File file = new File(FileUtil.UPLOAD_PATH+"/"+newName);
			itemCommand.getUpload().transferTo(file);
		}
		return "redirect:/main/main.do";
	}
}