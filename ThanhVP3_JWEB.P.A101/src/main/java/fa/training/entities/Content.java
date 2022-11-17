package fa.training.entities;

import java.sql.Date;

public class Content {
private int Id;
private String Title;
private String Brief;
private String Content;
private Date CreatedDate;
private Date UpdateTime;
private int Sort;
private Member member;

public Content() {
	// TODO Auto-generated constructor stub
}

public Content(int id, String title, String brief, String content, Date createdDate, Date updateTime, int sort,
		Member member) {
	super();
	Id = id;
	Title = title;
	Brief = brief;
	Content = content;
	CreatedDate = createdDate;
	UpdateTime = updateTime;
	Sort = sort;
	this.member = member;
}

public int getId() {
	return Id;
}

public void setId(int id) {
	Id = id;
}

public String getTitle() {
	return Title;
}

public void setTitle(String title) {
	Title = title;
}

public String getBrief() {
	return Brief;
}

public void setBrief(String brief) {
	Brief = brief;
}

public String getContent() {
	return Content;
}

public void setContent(String content) {
	Content = content;
}

public Date getCreatedDate() {
	return CreatedDate;
}

public void setCreatedDate(Date createdDate) {
	CreatedDate = createdDate;
}

public Date getUpdateTime() {
	return UpdateTime;
}

public void setUpdateTime(Date updateTime) {
	UpdateTime = updateTime;
}

public int getSort() {
	return Sort;
}

public void setSort(int sort) {
	Sort = sort;
}

public Member getMember() {
	return member;
}

public void setMember(Member member) {
	this.member = member;
}


}
