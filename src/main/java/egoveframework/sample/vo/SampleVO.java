package egoveframework.sample.vo;

import java.sql.Date;

public class SampleVO {
	
	private String id;
	private String title;
	private String reg_user;
	private String content;
	
	private Date reg_date;
	
	private String searchCondition;
	private String searchKeyword;
	


	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		System.out.println("SampleVO(content):"+content);
		this.content = content;
	}

	public String getReg_user() {
		return reg_user;
	}
	public void setReg_user(String reg_user) {
		this.reg_user = reg_user;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "SampleVO [id=" + id + ", title=" + title + ", reg_user=" + reg_user + ", content=" + content
				+ ", reg_date=" + reg_date + "]";
	}

	
	
	

}
