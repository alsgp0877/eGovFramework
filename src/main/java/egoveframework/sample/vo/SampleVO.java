package egoveframework.sample.vo;

import java.sql.Date;

public class SampleVO {
	
	private String id;
	private String title;
	private String regUser;
	private String content;
	
	private Date regDate;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		System.out.println("SampleVO(id):"+id);
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		System.out.println("SampleVO(title):"+title);
		this.title = title;
	}
	public String getRegUser() {
		return regUser;
	}
	public void setRegUser(String regUser) {
		System.out.println("SampleVO(regUser):"+regUser);
		this.regUser = regUser;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		System.out.println("SampleVO(content):"+content);
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		System.out.println("SampleVO(regDate):"+regDate);
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "SampleVO [id=" + id + ", title=" + title + ", regUser=" + regUser + ", content=" + content
				+ ", regDate=" + regDate + "]";
	}

	
	
	

}
