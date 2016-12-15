package kr.spring.item.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.spring.item.domain.ModelCommand;

@Repository
public interface ModelMapper {
	public List<ModelCommand> list(Map<String, Object> map);
	public int getCount(Map<String, Object> map);
	@Select("select * from model where mo_code=#{mo_code}")
	public ModelCommand selectModel(String mo_code);

}
