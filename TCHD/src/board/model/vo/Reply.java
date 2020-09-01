package board.model.vo;

import java.sql.Date;

public class Reply {
	private int replyId;
	private String replyContent;
	private String replyWriter;
	private Date createDate;
	private String status;
	
	public Reply() {}
	
	public Reply(int replyId, String replyContent, String replyWriter, Date createDate, String status) {
		super();
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.replyWriter = replyWriter;
		this.createDate = createDate;
		this.status = status;
	}
	
	public Reply(int replyId, String replyContent, Date createDate, String status) {
		super();
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.createDate = createDate;
		this.status = status;
	}
	
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", replyContent=" + replyContent + ", replyWriter=" + replyWriter
				+ ", createDate=" + createDate + ", status=" + status + "]";
	}
}
