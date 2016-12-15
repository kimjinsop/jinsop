package kr.spring.main.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.item.domain.ItemCommand;
import kr.spring.main.dao.MainMapper;

@Service("mainService")
public class MainServiceImpl implements MainService {
	
	@Resource
	private MainMapper mainMapper;
	
	@Override
	public List<ItemCommand> newList(Map<String, Object> map) {
		
		return mainMapper.newList(map);
	}

	@Override
	public List<ItemCommand> deadList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mainMapper.deadList(map);
	}

	@Override
	public List<ItemCommand> lowList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mainMapper.lowList(map);
	}
 
	@Override
	public int getnewCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mainMapper.getnewCount(map);
	}

	@Override
	public int getdeadCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mainMapper.getdeadCount(map);
	}

	@Override
	public int getlowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mainMapper.getlowCount(map);
	}

	

}
