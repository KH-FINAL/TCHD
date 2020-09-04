package support.model.vo;

import java.sql.Date;

public class Support {
	private int mem_no;		// 회원번호
	private String mem_id;	// 아이디
	private int sup_no;		// 후원번호
	private int sup_price;	// 후원금액
	private Date sup_date;	// 후원날짜
	
	public Support() {}

	public Support(String mem_id, int sup_price) {
		super();
		this.mem_id = mem_id;
		this.sup_price = sup_price;
	}

	public Support(int mem_no, String mem_id, int sup_no, int sup_price, Date sup_date) {
		super();
		this.mem_no = mem_no;
		this.mem_id = mem_id;
		this.sup_no = sup_no;
		this.sup_price = sup_price;
		this.sup_date = sup_date;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getSup_no() {
		return sup_no;
	}

	public void setSup_no(int sup_no) {
		this.sup_no = sup_no;
	}

	public int getSup_price() {
		return sup_price;
	}

	public void setSup_price(int sup_price) {
		this.sup_price = sup_price;
	}

	public Date getSup_date() {
		return sup_date;
	}

	public void setSup_date(Date sup_date) {
		this.sup_date = sup_date;
	}

	@Override
	public String toString() {
		return "Support [mem_no=" + mem_no + ", mem_id=" + mem_id + ", sup_no=" + sup_no + ", sup_price=" + sup_price
				+ ", sup_date=" + sup_date + "]";
	}
}