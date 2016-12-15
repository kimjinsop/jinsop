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
	//가입 시 포인트 테이블 생성
	@Insert("insert into point (mem_id) values (#{mem_id})")
	public void insertPoint(PointCommand pointCommand);
	//내 포인트 보기
	@Select("select * from point where mem_id=#{mem_id}")
	public PointCommand selectPoint(String mem_id);
	//포인트 충전
	@Update("UPDATE point set point=point+#{point} where mem_id=#{mem_id}")
	public void addPoint(PointCommand pointCommand);
	//포인트 삭감
	@Update("UPDATE point set point=point-#{point} where mem_id=#{mem_id}")
	public void refundPoint(PointCommand pointCommand);
	
	//관리자(카운트)
	public List<MemberCommand> list(Map<String, Object> map);
	@Select("select count(*) from member where mem_id!='삭제'")
	public int getRowCount(Map<String,Object> map);
}
