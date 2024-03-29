package kr.spring.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class MemberConfirmIdAjaxController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	@RequestMapping("/member/confirmId.do")
	@ResponseBody
	public Map<String,String> process(@RequestParam("id")String id){
		
		if(log.isDebugEnabled()){
			log.debug("id : " + id);
		}
		
		Map<String,String> map = new HashMap<String, String>();
		
		try{
			MemberCommand member = memberService.selectMember(id);
			if(member != null){
				//아이디 중복
				map.put("result", "idDuplicated");
			}else{
				//아이디 미중복
				map.put("result", "idNotFound");
			}
		}catch(Exception e){
			log.error(e);
			map.put("result", "failure");
		}		
		return map;
	}
}
