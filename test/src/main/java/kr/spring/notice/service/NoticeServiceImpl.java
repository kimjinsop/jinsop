package kr.spring.notice.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.notice.dao.NoticeMapper;
import kr.spring.notice.domain.NoticeCommand;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Resource(name="noticeMapper")
	private NoticeMapper noticeMapper;
	
	@Override
	public List<NoticeCommand> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return noticeMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return noticeMapper.getRowCount(map);
	}

	@Override
	public void insert(NoticeCommand notice) {
		// TODO Auto-generated method stub
		noticeMapper.insert(notice);
	}

	@Override
	public NoticeCommand selectNotice(Integer nb_num) {
		// TODO Auto-generated method stub
		return noticeMapper.selectNotice(nb_num);
	}

	@Override
	public void update(NoticeCommand notice) {
		// TODO Auto-generated method stub
		noticeMapper.update(notice);
	}

	@Override
	public void delete(Integer nb_num) {
		// TODO Auto-generated method stub
		noticeMapper.delete(nb_num);
	}
	
	
}