package kr.spring.item.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.item.domain.ItemCommand;
import kr.spring.item.service.ItemService;
import kr.spring.util.FileUtil;

@Controller
public class ItemDeleteController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private ItemService itemService;
	@RequestMapping("/item/delete.do")
	public String submit(@RequestParam("it_num")int it_num, HttpSession session) throws Exception{
		if(log.isDebugEnabled()){
			log.debug("it_num : " + it_num);
		}
		ItemCommand itemCommand = itemService.selectItem(it_num);
		String userId = (String)session.getAttribute("userId");
		
		if(!userId.equals(itemCommand.getMem_id())){
			throw new Exception("�α��� �� ���̵�� �ش� ���� ������ �� �����ϴ�.");
		}
		if(itemCommand.getIt_status().equals("C")){
			return "redirect:/main/main.do";
		}
		//�� ����
		itemService.delete(itemCommand.getIt_num());
		//���ϻ������� üũ
		if(itemCommand.getIt_image() != null){
			FileUtil.removeFile(itemCommand.getIt_image());
		}
		
		return "redirect:/item/list.do";
	}
}
