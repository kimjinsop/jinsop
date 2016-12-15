package kr.spring.point.domain;

public class PointCommand {
	private String mem_id;
	private int point;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "PointCommand [mem_id=" + mem_id + ", point=" + point + "]";
	}
}
