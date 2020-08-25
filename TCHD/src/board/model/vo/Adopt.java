package board.model.vo;

import java.util.Date;

public class Adopt {
	private int boNo;
	private String petKinds;
	private String petCategory;
	private String petGender;
	private String petName;
	private String petAge;
	private Date petRescueDate;
	private String petUnigender;
	private float petWeight;
	private String petColor;
	private String petSize;
	private String petComment;
	
	public Adopt(int boNo, String petKinds, String petCategory, String petGender, String petName, String petAge,
			Date petRescueDate, float petWeight, String petColor, String petSize) {
		super();
		this.boNo = boNo;
		this.petKinds = petKinds;
		this.petCategory = petCategory;
		this.petGender = petGender;
		this.petName = petName;
		this.petAge = petAge;
		this.petRescueDate = petRescueDate;
		this.petWeight = petWeight;
		this.petColor = petColor;
		this.petSize = petSize;
	}

	public Adopt(int boNo, String petKinds, String petCategory, String petGender, String petName, String petAge,
			Date petRescueDate, String petUnigender, float petWeight, String petColor, String petSize,
			String petComment) {
		super();
		this.boNo = boNo;
		this.petKinds = petKinds;
		this.petCategory = petCategory;
		this.petGender = petGender;
		this.petName = petName;
		this.petAge = petAge;
		this.petRescueDate = petRescueDate;
		this.petUnigender = petUnigender;
		this.petWeight = petWeight;
		this.petColor = petColor;
		this.petSize = petSize;
		this.petComment = petComment;
	}

	public int getBoNo() {
		return boNo;
	}

	public void setBoNo(int boNo) {
		this.boNo = boNo;
	}

	public String getPetKinds() {
		return petKinds;
	}

	public void setPetKinds(String petKinds) {
		this.petKinds = petKinds;
	}

	public String getPetCategory() {
		return petCategory;
	}

	public void setPetCategory(String petCategory) {
		this.petCategory = petCategory;
	}

	public String getPetGender() {
		return petGender;
	}

	public void setPetGender(String petGender) {
		this.petGender = petGender;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetAge() {
		return petAge;
	}

	public void setPetAge(String petAge) {
		this.petAge = petAge;
	}

	public Date getPetRescueDate() {
		return petRescueDate;
	}

	public void setPetRescueDate(Date petRescueDate) {
		this.petRescueDate = petRescueDate;
	}

	public String getPetUnigender() {
		return petUnigender;
	}

	public void setPetUnigender(String petUnigender) {
		this.petUnigender = petUnigender;
	}

	public float getPetWeight() {
		return petWeight;
	}

	public void setPetWeight(float petWeight) {
		this.petWeight = petWeight;
	}

	public String getPetColor() {
		return petColor;
	}

	public void setPetColor(String petColor) {
		this.petColor = petColor;
	}

	public String getPetSize() {
		return petSize;
	}

	public void setPetSize(String petSize) {
		this.petSize = petSize;
	}

	public String getPetComment() {
		return petComment;
	}

	public void setPetComment(String petComment) {
		this.petComment = petComment;
	}

	@Override
	public String toString() {
		return "Adopt [boNo=" + boNo + ", petKinds=" + petKinds + ", petCategory=" + petCategory + ", petGender="
				+ petGender + ", petName=" + petName + ", petAge=" + petAge + ", petRescueDate=" + petRescueDate
				+ ", petUnigender=" + petUnigender + ", petWeight=" + petWeight + ", petColor=" + petColor
				+ ", petSize=" + petSize + ", petComment=" + petComment + "]";
	}
	
} // class end
