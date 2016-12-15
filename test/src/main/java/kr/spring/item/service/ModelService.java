package kr.spring.item.service;

import java.util.List;
import java.util.Map;

import kr.spring.item.domain.ModelCommand;

public interface ModelService {
	public List<ModelCommand> list(Map<String, Object> map);
	public int getCount(Map<String, Object> map);
	public ModelCommand selectModel(String mo_code);

}
