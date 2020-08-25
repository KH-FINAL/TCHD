package board.model.vo;

public class Questions {
	private int boNo;
	private String boPwd;
	
	public Questions() {}

	public Questions(int boNo) {
		super();
		this.boNo = boNo;
	}

	public Questions(int boNo, String boPwd) {
		super();
		this.boNo = boNo;
		this.boPwd = boPwd;
	}

	public int getBoNo() {
		return boNo;
	}

	public void setBoNo(int boNo) {
		this.boNo = boNo;
	}

	public String getBoPwd() {
		return boPwd;
	}

	public void setBoPwd(String boPwd) {
		this.boPwd = boPwd;
	}

	@Override
	public String toString() {
		return "Questions [boNo=" + boNo + ", boPwd=" + boPwd + "]";
	}
	
	
	
}
