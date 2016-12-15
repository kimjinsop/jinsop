package kr.spring.buy.domain;

import java.sql.Date;

public class BuyCommand {
	
	private int buy_num;
	private String mem_id;
	private int it_num;
	private String buy_zip;
	private String buy_addr1;
	private String buy_addr2;
	private Date buy_register;
	//items
	private String it_brand;
	private String it_model;
	private String it_image;
	private int it_size;
	private int it_price;
	private String it_status;
	private int model_cnt;
	private int total_price;
	
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getModel_cnt() {
		return model_cnt;
	}
	public void setModel_cnt(int model_cnt) {
		this.model_cnt = model_cnt;
	}
	public String getIt_brand() {
		return it_brand;
	}
	public void setIt_brand(String it_brand) {
		this.it_brand = it_brand;
	}
	public String getIt_model() {
		return it_model;
	}
	public void setIt_model(String it_model) {
		this.it_model = it_model;
	}
	public String getIt_image() {
		return it_image;
	}
	public void setIt_image(String it_image) {
		this.it_image = it_image;
	}
	public int getIt_size() {
		return it_size;
	}
	public void setIt_size(int it_size) {
		this.it_size = it_size;
	}
	public int getIt_price() {
		return it_price;
	}
	public void setIt_price(int it_price) {
		this.it_price = it_price;
	}
	public String getIt_status() {
		return it_status;
	}
	public void setIt_status(String it_status) {
		this.it_status = it_status;
	}
	public int getBuy_num() {
		return buy_num;
	}
	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getIt_num() {
		return it_num;
	}
	public void setIt_num(int it_num) {
		this.it_num = it_num;
	}
	public String getBuy_zip() {
		return buy_zip;
	}
	public void setBuy_zip(String buy_zip) {
		this.buy_zip = buy_zip;
	}
	public String getBuy_addr1() {
		return buy_addr1;
	}
	public void setBuy_addr1(String buy_addr1) {
		this.buy_addr1 = buy_addr1;
	}
	public String getBuy_addr2() {
		return buy_addr2;
	}
	public void setBuy_addr2(String buy_addr2) {
		this.buy_addr2 = buy_addr2;
	}
	public Date getBuy_register() {
		return buy_register;
	}
	public void setBuy_register(Date buy_register) {
		this.buy_register = buy_register;
	}
	@Override
	public String toString() {
		return "BuyCommand [buy_num=" + buy_num + ", mem_id=" + mem_id + ", it_num=" + it_num + ", buy_zip=" + buy_zip
				+ ", buy_addr1=" + buy_addr1 + ", buy_addr2=" + buy_addr2 + ", buy_register=" + buy_register
				+ ", it_brand=" + it_brand + ", it_model=" + it_model + ", it_image=" + it_image + ", it_size="
				+ it_size + ", it_price=" + it_price + ", it_status=" + it_status + ", model_cnt=" + model_cnt
				+ ", total_price=" + total_price + "]";
	}

	

}
