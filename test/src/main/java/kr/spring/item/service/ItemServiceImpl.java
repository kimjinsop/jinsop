package kr.spring.item.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.item.dao.ItemMapper;
import kr.spring.item.domain.ItemCommand;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
	@Resource
	private ItemMapper itemMapper;

	@Override
	public List<ItemCommand> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itemMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itemMapper.getRowCount(map);
	}

	@Override
	public int getModelCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itemMapper.getModelCount(map);
	}

	@Override
	public void insert(ItemCommand item) {
		// TODO Auto-generated method stub
		itemMapper.insert(item);
	}

	@Override
	public ItemCommand selectItem(Integer it_num) {
		// TODO Auto-generated method stub
		return itemMapper.selectItem(it_num);
	}

	@Override
	public void update(ItemCommand item) {
		// TODO Auto-generated method stub
		itemMapper.update(item);
	}

	@Override
	public void delete(Integer it_num) {
		// TODO Auto-generated method stub
		itemMapper.delete(it_num);
	}

	@Override
	public List<ItemCommand> listByModel(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itemMapper.listByModel(map);
	}

	@Override
	public ItemCommand selectItemModel(String it_model) {
		// TODO Auto-generated method stub
		return itemMapper.selectItemModel(it_model);
	}

	@Override
	public void updateStatus(Integer it_num) {
		// TODO Auto-generated method stub
		itemMapper.updateStatus(it_num);
	}

	@Override
	public List<ItemCommand> sellList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itemMapper.sellList(map);
	}

	@Override
	public int getSellCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itemMapper.getSellCount(map);
	}

	@Override
	public List<ItemCommand> sellingList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itemMapper.sellingList(map);
	}

	@Override
	public int getSellingCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itemMapper.getSellingCount(map);
	}

	@Override
	public List<ItemCommand> soldList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itemMapper.soldList(map);
	}

	@Override
	public int getSoldCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itemMapper.getSoldCount(map);
	}

	@Override
	public List<ItemCommand> userSellList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itemMapper.userSellList(map);
	}

	@Override
	public int getUserSellCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itemMapper.getUserSellCount(map);
	}

	@Override
	public List<ItemCommand> userSellingList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itemMapper.userSellingList(map);
	}

	@Override
	public int getUserSellingCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itemMapper.getUserSellingCount(map);
	}

	@Override
	public List<ItemCommand> userSoldList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itemMapper.userSoldList(map);
	}

	@Override
	public int getUserSoldCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itemMapper.getUserSoldCount(map);
	}

	@Override
	public List<ItemCommand> marketValue(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itemMapper.marketValue(map);
	}
	
	//우수판매회원 주말추가
	@Override
	public List<ItemCommand> vipSellList(Map<String, Object> map) {
		return itemMapper.vipSellList(map);
	}

	@Override
	public int getVipSellCount(Map<String, Object> map) {
		return itemMapper.getVipSellCount(map);
	}
	
	@Override
	public void sellAgree(List<Integer> list) {
		itemMapper.sellAgree(list);
	}

}
