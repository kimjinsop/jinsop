package kr.spring.item.domain;

public class ModelCommand {
	private String mo_model;
	private String mo_brand;
	private String mo_image;
	private String mo_code;
	
	public String getMo_code() {
		return mo_code;
	}
	public void setMo_code(String mo_code) {
		this.mo_code = mo_code;
	}
	public String getMo_model() {
		return mo_model;
	}
	public void setMo_model(String mo_model) {
		this.mo_model = mo_model;
	}
	public String getMo_brand() {
		return mo_brand;
	}
	public void setMo_brand(String mo_brand) {
		this.mo_brand = mo_brand;
	}
	public String getMo_image() {
		return mo_image;
	}
	public void setMo_image(String mo_image) {
		this.mo_image = mo_image;
	}
	@Override
	public String toString() {
		return "ModelCommand [mo_model=" + mo_model + ", mo_brand=" + mo_brand + ", mo_image=" + mo_image + ", mo_code="
				+ mo_code + "]";
	}

}
