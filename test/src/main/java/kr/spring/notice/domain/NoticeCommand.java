package kr.spring.notice.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class NoticeCommand {
	private int nb_num;
	@NotEmpty
	private String mem_id;
	@NotEmpty
	private String nb_title;
	@NotEmpty
	private String nb_content;
	private Date nb_register;
	
	public int getNb_num() {
		return nb_num;
	}
	public void setNb_num(int nb_num) {
		this.nb_num = nb_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getNb_title() {
		return nb_title;
	}
	public void setNb_title(String nb_title) {
		this.nb_title = nb_title;
	}
	public String getNb_content() {
		return nb_content;
	}
	public void setNb_content(String nb_content) {
		this.nb_content = nb_content;
	}
	public Date getNb_register() {
		return nb_register;
	}
	public void setNb_register(Date nb_register) {
		this.nb_register = nb_register;
	}
	@Override
	public String toString() {
		return "NoticeCommand [nb_num=" + nb_num + ", mem_id=" + mem_id + ", nb_title=" + nb_title + ", nb_content="
				+ nb_content + ", nb_register=" + nb_register + "]";
	}
	
}
