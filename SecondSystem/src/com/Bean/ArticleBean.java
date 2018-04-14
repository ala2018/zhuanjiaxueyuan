package com.Bean;

import java.util.Date;

public class ArticleBean {
	
	int id;
	String title;
	String contents;
	Date date;
	String classification;
	String author;
	public ArticleBean() {
		super();
	
	}
	public ArticleBean(int id, String title, String contents, Date date,
			String classification, String author) {
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.date = date;
		this.classification = classification;
		this.author = author;
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	

}
