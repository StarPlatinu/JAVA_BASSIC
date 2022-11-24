package model;

import java.util.Date;

public class Content {
	private String title;
	private String brief;
	private String content;
	private String createdDate;
	private String UpdateTime;
	private int Sort;
	private int AuthorId;

	public Content() {
		// TODO Auto-generated constructor stub
	}

	public Content(String title, String brief, String content, String createdDate, String updateTime, int sort,
			int authorId) {
		super();
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createdDate = createdDate;
		UpdateTime = updateTime;
		Sort = sort;
		AuthorId = authorId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdateTime() {
		return UpdateTime;
	}

	public void setUpdateTime(String updateTime) {
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
