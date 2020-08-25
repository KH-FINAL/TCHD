package board.model.vo;

import java.sql.Date;

public class Volunteer {
	private int boNo;
	private int voMaxmember;
	private int voApplymember;
	private String voDeadline;
	private Date voDate;
	private String voArea;
	private String voPlace;
	private String voComment;
	
	public Volunteer() {}

	public Volunteer(int boNo, int voMaxmember, int voApplymember, String voDeadline, Date voDate, String voArea,
			String voPlace, String voComment) {
		super();
		this.boNo = boNo;
		this.voMaxmember = voMaxmember;
		this.voApplymember = voApplymember;
		this.voDeadline = voDeadline;
		this.voDate = voDate;
		this.voArea = voArea;
		this.voPlace = voPlace;
		this.voComment = voComment;
	}

	public Volunteer(int boNo, String voDeadline, String voArea) {
		super();
		this.boNo = boNo;
		this.voDeadline = voDeadline;
		this.voArea = voArea;
	}

	public Volunteer(int voMaxmember, int voApplymember, String voDeadline, Date voDate, String voArea, String voPlace,
			String voComment) {
		super();
		this.voMaxmember = voMaxmember;
		this.voApplymember = voApplymember;
		this.voDeadline = voDeadline;
		this.voDate = voDate;
		this.voArea = voArea;
		this.voPlace = voPlace;
		this.voComment = voComment;
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
		return "Volunteer [boNo=" + boNo + ", voMaxmember=" + voMaxmember + ", voApplymember=" + voApplymember
				+ ", voDeadline=" + voDeadline + ", voDate=" + voDate + ", voArea=" + voArea + ", voPlace=" + voPlace
				+ ", voComment=" + voComment + "]";
	}
}