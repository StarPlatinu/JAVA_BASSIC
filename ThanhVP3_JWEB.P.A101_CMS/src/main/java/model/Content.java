package model;

import java.util.Date;

public class Content {
private int id;
private String title;
private String brief;
private String context;
private Date createdDate;
private Date UpdateTime;
private int Sort;
private int AuthorId;

public Content() {
	// TODO Auto-generated constructor stub
}

public Content(int id, String title, String brief, String context, Date createdDate, Date updateTime, int sort,
		int authorId) {
	super();
	this.id = id;
	this.title = title;
	this.brief = brief;
	this.context = context;
	this.createdDate = createdDate;
	UpdateTime = updateTime;
	Sort = sort;
	AuthorId = authorId;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getBrief() {
	return brief;
}

public void setBrief(String brief) {
	this.brief = brief;
}

public String getContext() {
	return context;
}

public void setContext(String context) {
	this.context = context;
}

public Date getCreatedDate() {
	return createdDate;
}

public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
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

public int getAuthorId() {
	return AuthorId;
}

public void setAuthorId(int authorId) {
	AuthorId = authorId;
}

}
