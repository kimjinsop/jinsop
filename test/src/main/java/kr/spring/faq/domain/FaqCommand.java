package kr.spring.faq.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class FaqCommand {
	private int faq_num;
	@NotEmpty
	private String mem_id;
	@NotEmpty
	private String faq_title;
	@NotEmpty
	private String faq_content;
	private Date faq_register;
	
	public int getFaq_num() {
		return faq_num;
	}
	public void setFaq_num(int faq_num) {
		this.faq_num = faq_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getFaq_title() {
		return faq_title;
	}
	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}
	public String getFaq_content() {
		return faq_content;
	}
	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}
	public Date getFaq_register() {
		return faq_register;
	}
	public void setFaq_register(Date faq_register) {
		this.faq_register = faq_register;
	}
	@Override
	public String toString() {
		return "FaqCommand [faq_num=" + faq_num + ", mem_id=" + mem_id + ", faq_title=" + faq_title + ", faq_content="
				+ faq_content + ", faq_register=" + faq_register + "]";
	}
	
}
