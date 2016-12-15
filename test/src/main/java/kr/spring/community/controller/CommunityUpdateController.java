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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.spring.community.domain.CommunityCommand;
import kr.spring.community.service.CommunityService;
import kr.spring.util.FileUtil;

@Controller
@SessionAttributes("command")
public class CommunityUpdateController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private CommunityService communityService;
	
	@RequestMapping(value="/community/update.do", method=RequestMethod.GET)
	public String form(@RequestParam("cm_num") int cm_num, Model model) {
		CommunityCommand command = communityService.selectCommunity(cm_num);
		model.addAttribute("command", command);
		return "communityUpdate";
	}
	
	@RequestMapping(value="/community/update.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid CommunityCommand communitycommand, BindingResult result, SessionStatus status, HttpSession session) throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("communitycommand : " + communitycommand);
		}
		String userId = (String)session.getAttribute("userId");
		if(!userId.equals(communitycommand.getMem_id())) {
			throw new Exception(userId + " 님의 글이 아닙니다.");
		}
		if(result.hasErrors()) {
			return "communityUpdate";
		}
		
		CommunityCommand community = null;
		String oldFileName = "";
		community = communityService.selectCommunity(communitycommand.getCm_num());
		
		//재등록 파일이 있을 시 기존 파일 삭제 / 재등록 파일 없을 시 기존 파일 세팅
		oldFileName = community.getCm_image();
		
		if(!communitycommand.getUpload().isEmpty()) {
			communitycommand.setCm_image(FileUtil.rename(communitycommand.getUpload().getOriginalFilename()));
		} else {
			communitycommand.setCm_image(oldFileName);
		}
		
		communityService.update(communitycommand);
		status.setComplete();
		
		if(!communitycommand.getUpload().isEmpty()) {
			File file = new File(FileUtil.UPLOAD_PATH + "/" + communitycommand.getCm_image());
			communitycommand.getUpload().transferTo(file);
			if(oldFileName!=null) {
				FileUtil.removeFile(oldFileName);
			}
		}
		
		return "redirect:/community/list.do";
	}

}
