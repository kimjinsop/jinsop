package kr.spring.item.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.item.domain.ItemCommand;

@Transactional
public interface ItemService {
	@Transactional(readOnly=true)
	public List<ItemCommand> list(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);
	public int getModelCount(Map<String,Object> map);
	public void insert(ItemCommand item);
	public ItemCommand selectItem(Integer it_num);
	public void update(ItemCommand item);
	public void delete(Integer it_num);
	@Transactional(readOnly=true)
	public List<ItemCommand> listByModel(Map<String, Object> map);
	public ItemCommand selectItemModel(String it_model);
	public void updateStatus(Integer it_num);

	//판매 목록(관리자)
	public List<ItemCommand> sellList(Map<String, Object> map);
	public int getSellCount(Map<String,Object> map);
	public List<ItemCommand> sellingList(Map<String, Object> map);
	public int getSellingCount(Map<String,Object> map);
	public List<ItemCommand> soldList(Map<String, Object> map);
	public int getSoldCount(Map<String,Object> map);
	public void sellAgree(List<Integer> list);

	//판매 목록(사용자)
	public List<ItemCommand> userSellList(Map<String, Object> map);
	public int getUserSellCount(Map<String,Object> map);
	public List<ItemCommand> userSellingList(Map<String, Object> map);
	public int getUserSellingCount(Map<String,Object> map);
	public List<ItemCommand> userSoldList(Map<String, Object> map);
	public int getUserSoldCount(Map<String,Object> map);
	
	//시세 정보
	public List<ItemCommand> marketValue(Map<String, Object> map);
	
	// 우수구매회원
	public List<ItemCommand> vipSellList(Map<String, Object> map);
	public int getVipSellCount(Map<String, Object>map);

}
