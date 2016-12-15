package kr.spring.notice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.notice.domain.NoticeCommand;

@Repository
public interface NoticeMapper {
	public List<NoticeCommand> list(Map<String, Object> map);
	@Select("select count(*) from noticeboard")
	public int getRowCount(Map<String, Object> map);
	@Insert("insert into noticeboard (nb_num, mem_id, nb_title, nb_content) values (nb_seq.nextval, #{mem_id}, #{nb_title}, #{nb_content})")
	public void insert(NoticeCommand notice);
	@Select("select * from noticeboard where nb_num=#{nb_num}")
	public NoticeCommand selectNotice(Integer nb_num);
	@Update("update noticeboard set nb_title=#{nb_title}, nb_content=#{nb_content}, mem_id=#{mem_id} where nb_num=${nb_num}")
	public void update(NoticeCommand notice);
	@Delete("delete from noticeboard where nb_num=#{nb_num}")
	public void delete(Integer nb_num);

}
