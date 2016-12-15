package kr.spring.community.domain;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class CommunityCommand {
	
	private int cm_num;
	private String mem_id;
	private String cm_title;
	private String cm_content;
	private MultipartFile upload;
	private String cm_image;
	private Date cm_register;
	private int cm_readcount;
	private int cm_reply;

	public int getCm_num() {
		return cm_num;
	}
	public int getCm_reply() {
		return cm_reply;
	}
	public void setCm_reply(int cm_reply) {
		this.cm_reply = cm_reply;
	}
	public void setCm_num(int cm_num) {
		this.cm_num = cm_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getCm_title() {
		return cm_title;
	}
	public void setCm_title(String cm_title) {
		this.cm_title = cm_title;
	}
	public String getCm_content() {
		return cm_content;
	}
	public void setCm_content(String cm_content) {
		this.cm_content = cm_content;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	public String getCm_image() {
		return cm_image;
	}
	public void setCm_image(String cm_image) {
		this.cm_image = cm_image;
	}
	public Date getCm_register() {
		return cm_register;
	}
	public void setCm_register(Date cm_register) {
		this.cm_register = cm_register;
	}
	public int getCm_readcount() {
		return cm_readcount;
	}
	public void setCm_readcount(int cm_readcount) {
		this.cm_readcount = cm_readcount;
	}
	@Override
	public String toString() {
		return "CommunityCommand [cm_num=" + cm_num + ", mem_id=" + mem_id + ", cm_title=" + cm_title + ", cm_content="
				+ cm_content + ", upload=" + upload + ", cm_image=" + cm_image + ", cm_register=" + cm_register
				+ ", cm_readcount=" + cm_readcount +  "]";
	}
		
}
