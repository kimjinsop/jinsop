package kr.spring.buy.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.buy.dao.BuyMapper;
import kr.spring.buy.domain.BuyCommand;

@Service("buyService")
public class BuyServiceImpl implements BuyService{
	@Resource
	private BuyMapper buyMapper;
	
	@Override
	public void insert(BuyCommand buy) {
		buyMapper.insert(buy);
	}

	@Override
	public BuyCommand selectItem(Integer buy_num) {
		return buyMapper.selectItem(buy_num);
	}

	@Override
	public List<BuyCommand> list(Map<String, Object> map) {
		return buyMapper.list(map);
	}
	
	@Override
	public int getRowCount(Map<String, Object> map) {
		return buyMapper.getRowCount(map);
	}

	@Override
	public void UpdateSellerPoint(Integer it_num) {
		buyMapper.UpdateSellerPoint(it_num);
	}

	@Override
	public void UpdateBuyerPoint(Map<String, Object> map) {
		buyMapper.UpdateBuyerPoint(map);
	}
	/*관리자 구매 목록*/
	@Override
	public List<BuyCommand> buyList(Map<String, Object> map) {
		return buyMapper.buyList(map);
	}

	@Override
	public int getbuyCount(Map<String, Object> map) {
		return buyMapper.getbuyCount(map);
	}
	/*우수 구매 회원 목록*/	
	@Override
	public List<BuyCommand> vipBuyList(Map<String, Object> map) {
		return buyMapper.vipBuyList(map);
	}

	@Override
	public int getVipBuyCount(Map<String, Object> map) {
		return buyMapper.getVipBuyCount(map);
	}
}
