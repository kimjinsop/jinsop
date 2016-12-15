package kr.spring.buy.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.buy.domain.BuyCommand;

@Transactional
public interface BuyService {
	public void insert(BuyCommand buy);
	@Transactional(readOnly=true)
	public BuyCommand selectItem(Integer buy_num);
	public void UpdateSellerPoint(Integer it_num);
	public void UpdateBuyerPoint(Map<String, Object> map);
	//내 구매목록
	@Transactional(readOnly=true)
	public List<BuyCommand> list(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);
	
	//관리자 구매 목록
		@Transactional(readOnly=true)
		public List<BuyCommand> buyList(Map<String, Object> map);
		@Transactional(readOnly=true)
		public int getbuyCount(Map<String,Object> map);
		
		//우수 구매왕 james
		public List<BuyCommand> vipBuyList(Map<String, Object> map);
		public int getVipBuyCount(Map<String,Object> map);
	
}
