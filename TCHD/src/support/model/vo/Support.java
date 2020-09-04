package support.model.vo;

import java.sql.Date;

public class Support {
	int sup_no; // 후원 번호
	int mem_no; // 회원 번호
	int sup_price; // 후원 금액
	Date sup_date; // 후원 날짜
	
	public Support() {}

	public Support(int sup_no, int mem_no, int sup_price, Date sup_date) {
		super();
		this.sup_no = sup_no;
		this.mem_no = mem_no;
		this.sup_price = sup_price;
		this.sup_date = sup_date;
	}

	public int getSup_no() {
		return sup_no;
	}

	public void setSup_no(int sup_no) {
		this.sup_no = sup_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
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
		return "Support [sup_no=" + sup_no + ", mem_no=" + mem_no + ", sup_price=" + sup_price + ", sup_date="
				+ sup_date + "]";
	}
}
