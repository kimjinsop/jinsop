package kr.spring.member.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.member.dao.MemberMapper;
import kr.spring.member.domain.MemberCommand;
import kr.spring.point.domain.PointCommand;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Resource(name="memberMapper")
	private MemberMapper memberMapper;
	
	@Override
	public void insert(MemberCommand member) {
		memberMapper.insert(member);
	}

	@Override
	public MemberCommand selectMember(String mem_id) {
	
		return memberMapper.selectMember(mem_id);
	}

	@Override
	public void update(MemberCommand member) {
		memberMapper.update(member);
		
	}

	@Override
	public void delete(String id) {
		memberMapper.delete(id);
	}

	@Override
	public PointCommand selectPoint(String mem_id) {
		
		return memberMapper.selectPoint(mem_id);
	}

	@Override
	public void addPoint(PointCommand pointCommand) {
		memberMapper.addPoint(pointCommand);
	}

	@Override
	public void insertPoint(PointCommand pointCommand) {
		memberMapper.insertPoint(pointCommand);
	}

	@Override
	public void refundPoint(PointCommand pointCommand) {
		memberMapper.refundPoint(pointCommand);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return memberMapper.getRowCount(map);
	}

	@Override
	public List<MemberCommand> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return memberMapper.list(map);
	}

}
