package kr.spring.community.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.community.domain.CommunityCommand;
import kr.spring.community.domain.ReplyCommand;

@Transactional
public interface CommunityService {
	@Transactional(readOnly=true)
	public List<CommunityCommand> list(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String, Object> map);
	public void insert(CommunityCommand community);
	@Transactional(readOnly=true)
	public CommunityCommand selectCommunity(Integer cm_num);
	public void updateHit(Integer cm_num);
	public void update(CommunityCommand community);
	public void delete(Integer cm_num);
	
	@Transactional(readOnly=true)
	public List<ReplyCommand> listReply(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCountReply(Map<String, Object> map);
	public void insertReply(ReplyCommand reply);
	public void updateReply(ReplyCommand reply);
	public void deleteReply(Integer re_num);
	
}
  