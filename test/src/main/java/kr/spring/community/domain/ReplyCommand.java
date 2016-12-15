package kr.spring.community.domain;

import java.sql.Date;

public class ReplyCommand {
	private int re_num;
	private String mem_id;
	private int cm_num;
	private String re_content;
	private Date re_register;
	
	public int getRe_num() {
		return re_num;
	}
	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getCm_num() {
		return cm_num;
	}
	public void setCm_num(int cm_num) {
		this.cm_num = cm_num;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public Date getRe_register() {
		return re_register;
	}
	public void setRe_register(Date re_register) {
		this.re_register = re_register;
	}
	@Override
	public String toString() {
		return "CommunityReplyCommand [re_num=" + re_num + ", mem_id=" + mem_id + ", cm_num=" + cm_num + ", re_content="
				+ re_content + ", re_register=" + re_register + "]";
	}
		
}
