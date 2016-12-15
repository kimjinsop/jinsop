package kr.spring.member.domain;

import java.sql.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberCommand {
	@NotEmpty
	private String mem_id;
	@Size(min=6, max=15, message="PassWord를 입력하세요")
	private String mem_passwd;
	@NotEmpty
	private String mem_name;
	@NotEmpty
	private String mem_cell;
	private String mem_status;
	private Date mem_register;
	
	public boolean isCheckedPasswd(String userPasswd) {
		if(mem_status.equals("Y") && mem_passwd.equals(userPasswd)) {
			return true;
		}
		return false;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_passwd() {
		return mem_passwd;
	}
	public void setMem_passwd(String mem_passwd) {
		this.mem_passwd = mem_passwd;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_cell() {
		return mem_cell;
	}
	public void setMem_cell(String mem_cell) {
		this.mem_cell = mem_cell;
	}
	public String getMem_status() {
		return mem_status;
	}
	public void setMem_status(String mem_status) {
		this.mem_status = mem_status;
	}
	public Date getMem_register() {
		return mem_register;
	}
	public void setMem_register(Date mem_register) {
		this.mem_register = mem_register;
	}
	@Override
	public String toString() {
		return "Member [mem_id=" + mem_id + ", mem_passwd=" + mem_passwd + ", mem_name=" + mem_name + ", mem_cell="
				+ mem_cell + ", mem_status=" + mem_status + ", mem_register=" + mem_register + "]";
	}
		
}
