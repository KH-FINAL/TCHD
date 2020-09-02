package board.model.vo;

import java.sql.Date;

import member.model.vo.Member;

public class Questions {// 문의게시판

	private int boNo; // 게시글 번호
	private int boType; // 게시판 분류번호
	private String cateName; // 게시판 분류명
	private String boTitle; // 게시글 제목
	private String boContent; // 게시글 내용
	private int boCount; // 조회수
	private Date boDate; // 작성일자
	private int memNo; // 회원번호
	private String memId; // 아이디
	private String boDeleteYn; // 삭제여부 N:default
	private String memLeave; // 회원 탈퇴여부 N:default

	// 아래서부턴 글쓰기, 상세조회에서 사용
	private String boPwd; // 게시글 비밀번호 (비밀글)
	private String selectBoard; // 문의글 게시판 분류
	
	private String comContent; // 답변내용
	private Date comDate; // 답변 작성일자

	private String filePath; // 파일경로
	private String originName; // 원본파일명
	private String changeName; // 수정파일명

	public Questions() {
	}

	// 목록보기
	public Questions(int boNo, int boType, String cateName, String boTitle, String boContent, int boCount, Date boDate,
			int memNo, String memId, String boDeleteYn, String memLeave) {
		super();
		this.boNo = boNo;
		this.boType = boType;
		this.cateName = cateName;
		this.boTitle = boTitle;
		this.boContent = boContent;
		this.boCount = boCount;
		this.boDate = boDate;
		this.memNo = memNo;
		this.memId = memId;
		this.boDeleteYn = boDeleteYn;
		this.memLeave = memLeave;
	}

	
	 //상세보기 
	public Questions(int boNo, int boType, String cateName, String
	  boTitle, String boContent, int boCount, Date boDate, String memId, String
	  boDeleteYn) { super(); this.boNo = boNo; this.boType = boType; this.cateName=
	  cateName; this.boTitle = boTitle; this.boContent = boContent; this.boCount=
	  boCount; this.boDate = boDate; this.memId = memId; this.boDeleteYn =
	  boDeleteYn; }
	 

	// 작성
	public Questions(int boNo, String boTitle, String boContent, String memId,
			 String selectBoard, String boPwd,int boType) {
		super();
		this.boNo = boNo;
		this.boTitle = boTitle;
		this.boContent = boContent;
		this.memId = memId;
		this.selectBoard = selectBoard;
		this.boPwd = boPwd;
		this.boType = boType;
	}

	public Questions(int boNo, int boType, String cateName, String boTitle, String boContent, int boCount, Date boDate,
			int memNo, String memId, String boDeleteYn, String memLeave, String boPwd, String comContent, Date comDate,
			String filePath, String originName, String changeName) {
		super();
		this.boNo = boNo;
		this.boType = boType;
		this.cateName = cateName;
		this.boTitle = boTitle;
		this.boContent = boContent;
		this.boCount = boCount;
		this.boDate = boDate;
		this.memNo = memNo;
		this.memId = memId;
		this.boDeleteYn = boDeleteYn;
		this.memLeave = memLeave;
		this.boPwd = boPwd;
		this.comContent = comContent;
		this.comDate = comDate;
		this.filePath = filePath;
		this.originName = originName;
		this.changeName = changeName;
	}



	public Questions(int boNo, String boTitle, String boContent, String memId, Date boDate, int boCount, String selectBoard,
			int boType) {
		this.boNo = boNo;
		this.boTitle = boTitle;
		this.boContent = boContent;
		this.memId=memId;
		this.boDate = boDate;
		this.boCount = boCount;
		this.selectBoard = selectBoard;
		this.boType=boType;
	}

	public Questions( int boType, String boTitle, String boContent, String boPwd, String selectBoard, int memNo) {
		super();
		this.boType = boType;
		this.boTitle = boTitle;
		this.boContent = boContent;
		this.boPwd = boPwd;
		this.selectBoard=selectBoard;
		this.memNo=memNo;
	}

	public int getBoType() {
		return boType;
	}

	public void setBoType(int boType) {
		this.boType = boType;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
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

	public int getBoCount() {
		return boCount;
	}

	public void setBoCount(int boCount) {
		this.boCount = boCount;
	}

	public Date getBoDate() {
		return boDate;
	}

	public void setBoDate(Date boDate) {
		this.boDate = boDate;
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

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemLeave() {
		return memLeave;
	}

	public void setMemLeave(String memLeave) {
		this.memLeave = memLeave;
	}

	public String getComContent() {
		return comContent;
	}

	public void setComContent(String comContent) {
		this.comContent = comContent;
	}

	public Date getComDate() {
		return comDate;
	}

	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getSelectBoard() {
		return selectBoard;
	}

	public void setSelectBoard(String selectBoard) {
		this.selectBoard = selectBoard;
	}
	
	
		
	@Override
	public String toString() {
		return "Questions [boNo=" + boNo + ", boType=" + boType + ", cateName=" + cateName + ", boTitle=" + boTitle
				+ ", boContent=" + boContent + ", boCount=" + boCount + ", boDate=" + boDate + ", memNo=" + memNo
				+ ", memId=" + memId + ", boDeleteYn=" + boDeleteYn + ", memLeave=" + memLeave + ", boPwd=" + boPwd
				+ ", questionsSubject=" + selectBoard + ", comContent=" + comContent + ", comDate=" + comDate
				+ ", filePath=" + filePath + ", originName=" + originName + ", changeName=" + changeName + "]";
	}

}
