package kr.spring.item.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.item.domain.ItemCommand;

@Repository
public interface ItemMapper {
	@Insert("insert into items (it_num, it_brand, it_model, it_code, it_image, it_size, it_price, mem_id) values (it_seq.nextval, #{it_brand}, #{it_model}, #{it_code}, #{it_image, jdbcType=VARCHAR}, #{it_size}, #{it_price}, #{mem_id})")
	public void insert(ItemCommand item);
	@Select("SELECT * FROM items WHERE it_num = #{it_num}")
	public ItemCommand selectItem(Integer it_num);
	@Update("UPDATE items SET it_price=#{it_price} WHERE it_num=#{it_num}")
	public void update(ItemCommand item);
	@Delete("DELETE FROM items WHERE it_num=#{it_num}")
	public void delete(Integer it_num);
	public List<ItemCommand> list(Map<String, Object> map);
	public int getRowCount(Map<String,Object> map);
	public List<ItemCommand> listByModel(Map<String, Object> map);
	public int getModelCount(Map<String,Object> map);
	@Select("SELECT * FROM items WHERE it_model = #{it_model}")
	public ItemCommand selectItemModel(String it_model);
	//���� �� �������ͽ� ��ȭ
	@Update("UPDATE items SET it_status='C' WHERE it_num=#{it_num}")
	public void updateStatus(Integer it_num);

	//�Ǹ� ���(������) 
	public List<ItemCommand> sellList(Map<String, Object> map);
	public int getSellCount(Map<String,Object> map);
	public List<ItemCommand> sellingList(Map<String, Object> map);
	public int getSellingCount(Map<String,Object> map);
	public List<ItemCommand> soldList(Map<String, Object> map);
	public int getSoldCount(Map<String,Object> map);
	public int price(Map<String, Object> map);
	public void sellAgree(List<Integer> list);

	
	//�Ǹ� ���(�����)
	public List<ItemCommand> userSellList(Map<String, Object> map);
	public int getUserSellCount(Map<String,Object> map);
	public List<ItemCommand> userSellingList(Map<String, Object> map);
	public int getUserSellingCount(Map<String,Object> map);
	public List<ItemCommand> userSoldList(Map<String, Object> map);
	public int getUserSoldCount(Map<String,Object> map);
	
	//�ü� ����
	@Select("select avg(it_price) avg, max(it_price) max, min(it_price) min from items where it_status='Y' and it_code=#{it_code}")
	public List<ItemCommand> marketValue(Map<String, Object> map);
	
	//��������� ���(�ָ��߰�)
	public List<ItemCommand> vipSellList(Map<String, Object> map);
	public int getVipSellCount(Map<String, Object>map);
	
	//�귣�� ������ ���� ��Ʈ
	public int getBrandCount(Map<String, Object> map);
	
}
