package board.model.vo;

import java.sql.Date;

public class Volunteer {
	private int boNo;
	private int voMaxmember;
	private int voApplymember;
	private String voDeadline;
	private Date voDate;
	private String voArea;
	
	public Volunteer() {}

	public Volunteer(int boNo, int voMaxmember, int voApplymember, String voDeadline, Date voDate, String voArea) {
		super();
		this.boNo = boNo;
		this.voMaxmember = voMaxmember;
		this.voApplymember = voApplymember;
		this.voDeadline = voDeadline;
		this.voDate = voDate;
		this.voArea = voArea;
	}

	public Volunteer(int voMaxmember, int voApplymember, String voDeadline, Date voDate, String voArea) {
		super();
		this.voMaxmember = voMaxmember;
		this.voApplymember = voApplymember;
		this.voDeadline = voDeadline;
		this.voDate = voDate;
		this.voArea = voArea;
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

	@Override
	public String toString() {
		return "Volunteer [boNo=" + boNo + ", voMaxmember=" + voMaxmember + ", voApplymember=" + voApplymember
				+ ", voDeadline=" + voDeadline + ", voDate=" + voDate + ", voArea=" + voArea + "]";
	}
}