package board.model.vo;

import java.sql.Date;

public class Support {
	private int memNo;			// 회원번호
	private int memId;			// 아이디
	private int supNo;			// 후원번호
	private int supPrice;		// 후원금액
	private Date supDate;		// 후원날짜
	
	public Support() {}

	public Support(int memNo, int memId, int supNo, int supPrice, Date supDate) {
		super();
		this.memNo = memNo;
		this.memId = memId;
		this.supNo = supNo;
		this.supPrice = supPrice;
		this.supDate = supDate;
	}

	public Support(int supNo, int supPrice, Date supDate) {
		super();
		this.supNo = supNo;
		this.supPrice = supPrice;
		this.supDate = supDate;
	}

	public Support(int supPrice, Date supDate) {
		super();
		this.supPrice = supPrice;
		this.supDate = supDate;
	}

	@Override
	public String toString() {
		return "Support [memNo=" + memNo + ", memId=" + memId + ", supNo=" + supNo + ", supPrice=" + supPrice
				+ ", supDate=" + supDate + "]";
	}
}