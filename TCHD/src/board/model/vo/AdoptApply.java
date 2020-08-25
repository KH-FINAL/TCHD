package board.model.vo;

public class AdoptApply {
	private int applyNo;
	private String applyContent;
	private int memNo;
	private int boNo;
	
	public AdoptApply(int applyNo, String applyContent, int memNo, int boNo) {
		super();
		this.applyNo = applyNo;
		this.applyContent = applyContent;
		this.memNo = memNo;
		this.boNo = boNo;
	}

	public int getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(int applyNo) {
		this.applyNo = applyNo;
	}

	public String getApplyContent() {
		return applyContent;
	}

	public void setApplyContent(String applyContent) {
		this.applyContent = applyContent;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getBoNo() {
		return boNo;
	}

	public void setBoNo(int boNo) {
		this.boNo = boNo;
	}

	@Override
	public String toString() {
		return "AdoptApply [applyNo=" + applyNo + ", applyContent=" + applyContent + ", memNo=" + memNo + ", boNo="
				+ boNo + "]";
	}
	
} // class end
