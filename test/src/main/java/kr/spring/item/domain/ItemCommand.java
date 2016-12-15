package kr.spring.item.domain;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ItemCommand {
	private int it_num;
	private String mem_id;
	private String it_brand;
	private String it_model;
	private String it_code;
	private String it_image;
	private MultipartFile upload;
	private int it_size;
	private int it_price;
	private String it_status;
	private Date it_register;
	private int model_cnt;
	private int total_price;
	private List<Integer> yes;
	private int avg;
	private int max;
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public List<Integer> getYes() {
		return yes;
	}
	public void setYes(List<Integer> yes) {
		this.yes = yes;
	}
	private int min;
	
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public String getIt_code() {
		return it_code;
	}
	public void setIt_code(String it_code) {
		this.it_code = it_code;
	}
	public int getModel_cnt() {
		return model_cnt;
	}
	public void setModel_cnt(int model_cnt) {
		this.model_cnt = model_cnt;
	}
	public int getIt_num() {
		return it_num;
	}
	public void setIt_num(int it_num) {
		this.it_num = it_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
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
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
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
	public Date getIt_register() {
		return it_register;
	}
	public void setIt_register(Date it_register) {
		this.it_register = it_register;
	}
	@Override
	public String toString() {
		return "ItemCommand [it_num=" + it_num + ", mem_id=" + mem_id + ", it_brand=" + it_brand + ", it_model="
				+ it_model + ", it_code=" + it_code + ", it_image=" + it_image + ", upload=" + upload + ", it_size="
				+ it_size + ", it_price=" + it_price + ", it_status=" + it_status + ", it_register=" + it_register
				+ ", model_cnt=" + model_cnt + ", total_price=" + total_price + ", yes=" + yes + ", avg=" + avg
				+ ", max=" + max + ", min=" + min + ", getTotal_price()=" + getTotal_price() + ", getYes()=" + getYes()
				+ ", getAvg()=" + getAvg() + ", getMax()=" + getMax() + ", getMin()=" + getMin() + ", getIt_code()="
				+ getIt_code() + ", getModel_cnt()=" + getModel_cnt() + ", getIt_num()=" + getIt_num()
				+ ", getMem_id()=" + getMem_id() + ", getIt_brand()=" + getIt_brand() + ", getIt_model()="
				+ getIt_model() + ", getIt_image()=" + getIt_image() + ", getUpload()=" + getUpload()
				+ ", getIt_size()=" + getIt_size() + ", getIt_price()=" + getIt_price() + ", getIt_status()="
				+ getIt_status() + ", getIt_register()=" + getIt_register() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
