package kr.spring.buy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.spring.buy.domain.BuyCommand;

@Repository
public interface BuyMapper {
	@Insert("INSERT INTO buy (buy_num, mem_id, it_num, buy_zip, buy_addr1, buy_addr2) VALUES (buy_seq.nextval, #{mem_id}, #{it_num}, #{buy_zip}, #{buy_addr1}, #{buy_addr2})")
	public void insert(BuyCommand buy);
	@Select("SELECT * FROM items WHERE buy_num = #{buy_num}")
	public BuyCommand selectItem(Integer buy_num);
	@Update("UPDATE point SET point=point+(select it_price from items where it_num=#{it_num}) WHERE mem_id=(select mem_id from items where it_num=#{it_num})")
	public void UpdateSellerPoint(Integer it_num);
	@Update("UPDATE point SET point=point-(select it_price from items where it_num=#{it_num}) WHERE mem_id=#{mem_id}")
	public void UpdateBuyerPoint(Map<String, Object> map);
	//내 구매목록
	public List<BuyCommand> list(Map<String, Object> map);
	public int getRowCount(Map<String,Object> map);
	
	//관리자 구매 목록
	@Transactional(readOnly=true)
	public List<BuyCommand> buyList(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getbuyCount(Map<String,Object> map);
	
	//우수 구매 왕
	public List<BuyCommand> vipBuyList(Map<String, Object> map);
	public int getVipBuyCount(Map<String,Object> map);
}
