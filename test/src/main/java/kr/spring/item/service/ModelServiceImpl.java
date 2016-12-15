package kr.spring.item.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.item.dao.ModelMapper;
import kr.spring.item.domain.ModelCommand;

@Service("modelService")
public class ModelServiceImpl implements ModelService {
	@Resource
	private ModelMapper modelMapper;

	@Override
	public List<ModelCommand> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return modelMapper.list(map);
	}

	@Override
	public ModelCommand selectModel(String mo_code) {
		// TODO Auto-generated method stub
		return modelMapper.selectModel(mo_code);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return modelMapper.getCount(map);
	}

}
