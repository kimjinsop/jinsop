package kr.spring.member.service;

import java.util.List;
import java.util.Map;

import kr.spring.member.domain.MemberCommand;
import kr.spring.point.domain.PointCommand;

public interface MemberService {
	public void insert(MemberCommand member);
	public MemberCommand selectMember(String mem_id);
	public void update(MemberCommand member);
	public void delete(String id);
	public PointCommand selectPoint(String mem_id);
	public void addPoint(PointCommand pointCommand);
	public void insertPoint(PointCommand pointCommand);
	public void refundPoint(PointCommand pointCommand);
	public List<MemberCommand> list(Map<String, Object> map);
	public int getRowCount(Map<String,Object> map);
}
