package kr.spring.faq.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.faq.dao.FaqMapper;
import kr.spring.faq.domain.FaqCommand;

@Service("faqService")
public class FaqServiceImpl implements FaqService {

	@Resource(name="faqMapper")
	private FaqMapper faqMapper;
	
	@Override
	public List<FaqCommand> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return faqMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return faqMapper.getRowCount(map);
	}

	@Override
	public void insert(FaqCommand faq) {
		// TODO Auto-generated method stub
		faqMapper.insert(faq);
	}

	@Override
	public FaqCommand selectFaq(Integer faq_num) {
		// TODO Auto-generated method stub
		return faqMapper.selectFaq(faq_num);
	}

	@Override
	public void update(FaqCommand faq_num) {
		// TODO Auto-generated method stub
		faqMapper.update(faq_num);
	}

	@Override
	public void delete(Integer faq_num) {
		// TODO Auto-generated method stub
		faqMapper.delete(faq_num);
	}

}
