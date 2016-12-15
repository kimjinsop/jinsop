package kr.spring.notice.service;

import java.util.List;
import java.util.Map;

import kr.spring.notice.domain.NoticeCommand;

public interface NoticeService {
	public List<NoticeCommand> list(Map<String, Object> map);
	public int getRowCount(Map<String, Object> map);
	public void insert(NoticeCommand notice);
	public NoticeCommand selectNotice(Integer nb_num);
	public void update(NoticeCommand notice);
	public void delete(Integer nb_num);
	
}
