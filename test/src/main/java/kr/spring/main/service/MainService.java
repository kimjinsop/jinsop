package kr.spring.main.service;

import java.util.List;
import java.util.Map;

import kr.spring.item.domain.ItemCommand;

public interface MainService {
	
	public List<ItemCommand> newList(Map<String, Object> map);
	public List<ItemCommand> deadList(Map<String, Object> map);
	public List<ItemCommand> lowList(Map<String, Object> map);
	
	public int getnewCount(Map<String, Object> map);
	public int getdeadCount(Map<String, Object> map);
	public int getlowCount(Map<String, Object> map);
}
