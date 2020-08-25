package board.model.vo;

import java.sql.Date;

public class Board {
	private int boNo;
	private String boType;
	private String boTitle;
	private String boContent;
	private Date boDate;
	private int boCount;
	private String boDeleteYn;
	private int memNo;
	
	public Board(int boNo, String boType, String boTitle, String boContent, Date boDate, int boCount, String boDeleteYn,
			int memNo) {
		super();
		this.boNo = boNo;
		this.boType = boType;
		this.boTitle = boTitle;
		this.boContent = boContent;
		this.boDate = boDate;
		this.boCount = boCount;
		this.boDeleteYn = boDeleteYn;
		this.memNo = memNo;
	}

	public int getBoNo() {
		return boNo;
	}

	public void setBoNo(int boNo) {
		this.boNo = boNo;
	}

	public String getBoType() {
		return boType;
	}

	public void setBoType(String boType) {
		this.boType = boType;
	}

	public String getBoTitle() {
		return boTitle;
	}

	public void setBoTitle(String boTitle) {
		this.boTitle = boTitle;
	}

	public String getBoContent() {
		return boContent;
	}

	public void setBoContent(String boContent) {
		this.boContent = boContent;
	}

	public Date getBoDate() {
		return boDate;
	}

	public void setBoDate(Date boDate) {
		this.boDate = boDate;
	}

	public int getBoCount() {
		return boCount;
	}

	public void setBoCount(int boCount) {
		this.boCount = boCount;
	}

	public String getBoDeleteYn() {
		return boDeleteYn;
	}

	public void setBoDeleteYn(String boDeleteYn) {
		this.boDeleteYn = boDeleteYn;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	@Override
	public String toString() {
		return "Board [boNo=" + boNo + ", boType=" + boType + ", boTitle=" + boTitle + ", boContent=" + boContent
				+ ", boDate=" + boDate + ", boCount=" + boCount + ", boDeleteYn=" + boDeleteYn + ", memNo=" + memNo
				+ "]";
	}
	
} // class end
