package kr.spring.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import kr.spring.member.domain.MemberCommand;
import kr.spring.point.domain.PointCommand;

@Repository
public interface MemberMapper {
	@Insert("insert into member (mem_id, mem_passwd, mem_name, mem_cell) values (#{mem_id}, #{mem_passwd}, #{mem_name}, #{mem_cell})")
	public void insert(MemberCommand member);
	@Select("select * from member where mem_id=#{mem_id}")	
	public MemberCommand selectMember(String mem_id);
	@Update("update member set mem_passwd=#{mem_passwd}, mem_name=#{mem_name}, mem_cell=#{mem_cell} where mem_id=#{mem_id}")
	public void update(MemberCommand member);
	@Delete("update member set mem_name='*', mem_cell='*', mem_status='X' where mem_id=#{mem_id}")
	public void delete(String id);
	//���� �� ����Ʈ ���̺� ����
	@Insert("insert into point (mem_id) values (#{mem_id})")
	public void insertPoint(PointCommand pointCommand);
	//�� ����Ʈ ����
	@Select("select * from point where mem_id=#{mem_id}")
	public PointCommand selectPoint(String mem_id);
	//����Ʈ ����
	@Update("UPDATE point set point=point+#{point} where mem_id=#{mem_id}")
	public void addPoint(PointCommand pointCommand);
	//����Ʈ �谨
	@Update("UPDATE point set point=point-#{point} where mem_id=#{mem_id}")
	public void refundPoint(PointCommand pointCommand);
	
	//������(ī��Ʈ)
	public List<MemberCommand> list(Map<String, Object> map);
	@Select("select count(*) from member where mem_id!='����'")
	public int getRowCount(Map<String,Object> map);
}
