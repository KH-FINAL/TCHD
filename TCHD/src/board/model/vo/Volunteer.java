package board.model.vo;

import java.sql.Date;

public class Volunteer {
	private int memNo;				// 회원번호
	private int memId;				// 아이디
	private int boNo;				// 게시글번호
	private int voMaxmember;		// 정원
	private int voApplymember;		// 신청인원
	private String voDeadline;		// 마감유무
	private Date voDate;			// 봉사일시
	private String voArea;			// 지역선택
	private String voPlace;			// 봉사지
	private String voComment;		// 내용
	
	public Volunteer() {}

	public Volunteer(int memNo, int memId, int boNo, int voMaxmember, int voApplymember, String voDeadline, Date voDate, String voArea,
			String voPlace, String voComment) {
		super();
		this.memNo = memNo;
		this.memId = memId;
		this.boNo = boNo;
		this.voMaxmember = voMaxmember;
		this.voApplymember = voApplymember;
		this.voDeadline = voDeadline;
		this.voDate = voDate;
		this.voArea = voArea;
		this.voPlace = voPlace;
		this.voComment = voComment;
	}

	public Volunteer(int memNo, int memId, int boNo, String voDeadline, String voArea) {
		super();
		this.memNo = memNo;
		this.memId = memId;
		this.boNo = boNo;
		this.voDeadline = voDeadline;
		this.voArea = voArea;
	}

	public Volunteer(int memNo, int memId, int voMaxmember, int voApplymember, String voDeadline, Date voDate, String voArea, String voPlace,
			String voComment) {
		super();
		this.memNo = memNo;
		this.memId = memId;
		this.voMaxmember = voMaxmember;
		this.voApplymember = voApplymember;
		this.voDeadline = voDeadline;
		this.voDate = voDate;
		this.voArea = voArea;
		this.voPlace = voPlace;
		this.voComment = voComment;
	}
	 
	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

	public int getBoNo() {
		return boNo;
	}

	public void setBoNo(int boNo) {
		this.boNo = boNo;
	}

	public int getVoMaxmember() {
		return voMaxmember;
	}

	public void setVoMaxmember(int voMaxmember) {
		this.voMaxmember = voMaxmember;
	}

	public int getVoApplymember() {
		return voApplymember;
	}

	public void setVoApplymember(int voApplymember) {
		this.voApplymember = voApplymember;
	}

	public String getVoDeadline() {
		return voDeadline;
	}

	public void setVoDeadline(String voDeadline) {
		this.voDeadline = voDeadline;
	}

	public Date getVoDate() {
		return voDate;
	}

	public void setVoDate(Date voDate) {
		this.voDate = voDate;
	}

	public String getVoArea() {
		return voArea;
	}

	public void setVoArea(String voArea) {
		this.voArea = voArea;
	}

	public String getVoPlace() {
		return voPlace;
	}

	public void setVoPlace(String voPlace) {
		this.voPlace = voPlace;
	}

	public String getVoComment() {
		return voComment;
	}

	public void setVoComment(String voComment) {
		this.voComment = voComment;
	}

	@Override
	public String toString() {
		return "Volunteer [memNo=" + memNo + ", memId=" + memId + ", boNo=" + boNo + ", voMaxmember=" + voMaxmember
				+ ", voApplymember=" + voApplymember + ", voDeadline=" + voDeadline + ", voDate=" + voDate + ", voArea="
				+ voArea + ", voPlace=" + voPlace + ", voComment=" + voComment + "]";
	}
}