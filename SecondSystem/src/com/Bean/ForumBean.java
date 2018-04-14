package com.Bean;

public class ForumBean {

	private String title = null;
	private String contents = null;
	private String classification = null;
	private String sender = null;

	public ForumBean() {
		super();
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public String getcontents() {
		return contents;
	}

	public void setcontents(String contents) {
		this.contents = contents;
	}

	public String getclassification() {
		return classification;
	}

	public void setclassification(String classification) {
		this.classification = classification;
	}

	public String getsender() {
		return sender;
	}

	public void setsender(String sender) {
		this.sender = sender;
	}

}
