package kr.spring.community.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.community.domain.CommunityCommand;
import kr.spring.community.domain.ReplyCommand;

@Repository
public interface CommunityMapper {
	public List<CommunityCommand> list(Map<String, Object> map);
	public int getRowCount(Map<String, Object> map);
	@Insert("insert into community (cm_num, mem_id, cm_title, cm_content, cm_image) values (cm_seq.nextval, #{mem_id}, #{cm_title}, #{cm_content}, #{cm_image, jdbcType=VARCHAR})")
	public void insert(CommunityCommand community);
	@Select("select * from community where cm_num=#{cm_num}")
	public CommunityCommand selectCommunity(Integer cm_num);
	@Update("update community set cm_readcount=cm_readcount+1 where cm_num=#{cm_num}")
	public void updateHit(Integer cm_num);
	@Update("update community set cm_title=#{cm_title}, cm_content=#{cm_content}, cm_image=#{cm_image, jdbcType=VARCHAR} where cm_num=#{cm_num}")
	public void update(CommunityCommand community);
	@Update("update community set cm_title='삭제된 게시글 입니다.', cm_content='삭제된 게시글 입니다.', mem_id='admin', cm_image='' where cm_num=#{cm_num}")
	public void delete(Integer cm_num);

	
	
	public List<ReplyCommand> listReply(Map<String, Object> map);
	@Select("select count(*) cm_reply from reply where cm_num=#{cm_num}")
	public int getRowCountReply(Map<String, Object> map);
	@Insert("insert into reply (re_num, mem_id, cm_num, re_content) values (re_seq.nextval, #{mem_id}, #{cm_num}, #{re_content})")
	public void insertReply(ReplyCommand reply);
	@Update("update reply set re_content=#{re_content} where re_num=#{re_num}")
	public void updateReply(ReplyCommand reply);
	@Delete("delete from reply where re_num=#{re_num}")
	public void deleteReply(Integer re_num);
	
}
