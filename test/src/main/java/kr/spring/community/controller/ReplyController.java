package kr.spring.community.controller;

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

import kr.spring.community.domain.ReplyCommand;
import kr.spring.community.service.CommunityService;
import kr.spring.util.PagingUtil;

@Controller
public class ReplyController {
	private Logger log = Logger.getLogger(this.getClass());
	private int rowCount = 5;
	private int pageCount = 1;
	
	@Resource
	private CommunityService communityService;
	
	@RequestMapping("/community/re_listAjax.do")
	@ResponseBody
	public Map<String, Object> re_list(@RequestParam(value="pageNum", defaultValue="1") int currentPage, @RequestParam("cm_num") int cm_num) {
		if(log.isDebugEnabled()) {
			log.debug("currentPage : " + currentPage + ", cm_num : " + cm_num);
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cm_num", cm_num);
		
		int count = communityService.getRowCountReply(map);
		
		PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount, "re_listAjax.do");
		map.put("start", page.getStartCount());
		map.put("end", page.getEndCount());
		
		List<ReplyCommand> list = null;
		if(count>0) {
			list = communityService.listReply(map);
		} else {
			list = Collections.emptyList();
		}
		
		Map<String, Object> mapJson = new HashMap<String, Object>();
		mapJson.put("count", count);
		mapJson.put("rowCount", rowCount);
		mapJson.put("pageCount", pageCount);
		mapJson.put("list", list);
		
		return mapJson;
	}
	
	@RequestMapping("/community/re_writeAjax.do")
	@ResponseBody
	public Map<String, String> re_write(ReplyCommand replyCommand, HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("replyCommand : " + replyCommand);
		}
		Map<String, String> map = new HashMap<String, String>();
		try {
			String userId = (String)session.getAttribute("userId");
			if(userId==null) {
				map.put("result", "logout");
			} else {
				communityService.insertReply(replyCommand);
				map.put("result", "success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "failure");
		}

		return map;
	}
	
	@RequestMapping("/community/re_deleteAjax.do")
	@ResponseBody
	public Map<String, String> re_delete(@RequestParam("re_num") int re_num, @RequestParam("mem_id") String mem_id, HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("re_num : " + re_num + ", mem_id : " + mem_id);
		}
		Map<String, String> map = new HashMap<String, String>();
		try {
			String userId = (String)session.getAttribute("userId");
			if(userId==null) {
				map.put("result", "logout");
			} else if(userId!=null && userId.equals(mem_id)) {
				communityService.deleteReply(re_num);
				map.put("result", "success");
			} else {
				map.put("result", "worngAccess");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "failure");
		}
		return map;
	}
	
	@RequestMapping("/community/re_updateAjax.do")
	@ResponseBody
	public Map<String, String> re_update(ReplyCommand replyCommand, HttpSession session) {
		if(log.isDebugEnabled()) {
			log.debug("replyCommand : " + replyCommand);
		}
		Map<String, String> map = new HashMap<String, String>();
		try {
			String userId = (String)session.getAttribute("userId");
			if(userId==null) {
				map.put("result", "logout");
			} else if(userId!=null && userId.equals(replyCommand.getMem_id())) {
				communityService.updateReply(replyCommand);
				map.put("result", "success");
			} else {
				map.put("result", "wrongAccess");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "failure");
		}
		return map;
	}

}
