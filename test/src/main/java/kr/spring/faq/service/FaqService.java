package kr.spring.faq.service;

import java.util.List;
import java.util.Map;

import kr.spring.faq.domain.FaqCommand;

public interface FaqService {
	public List<FaqCommand> list(Map<String, Object> map);
	public int getRowCount(Map<String, Object> map);
	public void insert(FaqCommand faq);
	public FaqCommand selectFaq(Integer faq_num);
	public void update(FaqCommand faq_num);
	public void delete(Integer faq_num);
	
}
