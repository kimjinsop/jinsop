package kr.spring.community.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.community.dao.CommunityMapper;
import kr.spring.community.domain.CommunityCommand;
import kr.spring.community.domain.ReplyCommand;

@Service("communityService")
public class CommunityServiceImpl implements CommunityService {

	@Resource(name="communityMapper")
	private CommunityMapper communityMapper;
	
	@Override
	public List<CommunityCommand> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return communityMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return communityMapper.getRowCount(map);
	}

	@Override
	public void insert(CommunityCommand community) {
		// TODO Auto-generated method stub
		communityMapper.insert(community);
	}

	@Override
	public CommunityCommand selectCommunity(Integer cm_num) {
		// TODO Auto-generated method stub
		return communityMapper.selectCommunity(cm_num);
	}

	@Override
	public void updateHit(Integer cm_num) {
		// TODO Auto-generated method stub
		communityMapper.updateHit(cm_num);
	}

	@Override
	public void update(CommunityCommand community) {
		// TODO Auto-generated method stub
		communityMapper.update(community);
	}

	@Override
	public void delete(Integer cm_num) {
		// TODO Auto-generated method stub
		communityMapper.delete(cm_num);
	}

	@Override
	public List<ReplyCommand> listReply(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return communityMapper.listReply(map);
	}

	@Override
	public int getRowCountReply(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return communityMapper.getRowCountReply(map);
	}

	@Override
	public void insertReply(ReplyCommand reply) {
		// TODO Auto-generated method stub
		communityMapper.insertReply(reply);
	}

	@Override
	public void updateReply(ReplyCommand reply) {
		// TODO Auto-generated method stub
		communityMapper.updateReply(reply);
	}

	@Override
	public void deleteReply(Integer re_num) {
		// TODO Auto-generated method stub
		communityMapper.deleteReply(re_num);
	}

}
