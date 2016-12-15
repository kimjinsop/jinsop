package kr.spring.faq.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.faq.domain.FaqCommand;

@Repository
public interface FaqMapper {
	public List<FaqCommand> list(Map<String, Object> map);
	@Select("select count(*) from faq")
	public int getRowCount(Map<String, Object> map);
	@Insert("insert into faq (faq_num, mem_id, faq_title, faq_content) values (faq_seq.nextval, #{mem_id}, #{faq_title}, #{faq_content})")
	public void insert(FaqCommand faq);
	@Select("select * from faq where faq_num=#{faq_num}")
	public FaqCommand selectFaq(Integer faq_num);
	@Update("update faq set faq_title=#{faq_title}, faq_content=#{faq_content} where faq_num=#{faq_num}")
	public void update(FaqCommand faq);
	@Delete("delete from faq where faq_num=#{faq_num}")
	public void delete(Integer faq_num);
	

}
