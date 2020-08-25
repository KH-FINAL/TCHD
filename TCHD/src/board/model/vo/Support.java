package board.model.vo;

import java.sql.Date;

public class Support {
	private int supNo;
	private int supPrice;
	private Date supDate;
	private int memNO;
	
	public Support() {}

	public Support(int supNo, int supPrice, Date supDate, int memNO) {
		super();
		this.supNo = supNo;
		this.supPrice = supPrice;
		this.supDate = supDate;
		this.memNO = memNO;
	}

	public Support(int supPrice, Date supDate, int memNO) {
		super();
		this.supPrice = supPrice;
		this.supDate = supDate;
		this.memNO = memNO;
	}

	public Support(int supPrice, Date supDate) {
		super();
		this.supPrice = supPrice;
		this.supDate = supDate;
	}

	public int getSupNo() {
		return supNo;
	}

	public void setSupNo(int supNo) {
		this.supNo = supNo;
	}

	public int getSupPrice() {
		return supPrice;
	}

	public void setSupPrice(int supPrice) {
		this.supPrice = supPrice;
	}

	public Date getSupDate() {
		return supDate;
	}

	public void setSupDate(Date supDate) {
		this.supDate = supDate;
	}

	public int getMemNO() {
		return memNO;
	}

	public void setMemNO(int memNO) {
		this.memNO = memNO;
	}

	@Override
	public String toString() {
		return "Support [supNo=" + supNo + ", supPrice=" + supPrice + ", supDate=" + supDate + ", memNO=" + memNO + "]";
	}
}