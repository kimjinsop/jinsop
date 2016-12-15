package kr.spring.community.controller;

import java.io.File;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.spring.community.domain.CommunityCommand;
import kr.spring.community.service.CommunityService;
import kr.spring.util.FileUtil;

@Controller
@SessionAttributes("command")
public class CommunityWriteController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private CommunityService communityService;
	
	@RequestMapping(value="/community/write.do", method=RequestMethod.GET)
	public String form(HttpSession session, Model model) {
		String mem_id = (String)session.getAttribute("userId");
		
		CommunityCommand command = new CommunityCommand();
		command.setMem_id(mem_id);
		model.addAttribute("command", command);
		
		return "communityWrite";
	}
	
	@RequestMapping(value="/community/write.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid CommunityCommand communityCommand, BindingResult result, SessionStatus status) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("communityCommand : " + communityCommand);
		}
		
		String newName = "";
		if(!communityCommand.getUpload().isEmpty()) {
			newName = FileUtil.rename(communityCommand.getUpload().getOriginalFilename());
			communityCommand.setCm_image(newName);
		}
		communityService.insert(communityCommand);
		status.setComplete();
		
		if(!communityCommand.getUpload().isEmpty()) {
			File file = new File(FileUtil.UPLOAD_PATH + "/" + newName);
			communityCommand.getUpload().transferTo(file);
		}
		
		return "redirect:/community/list.do";
	}

}
