package com.Bean;

import java.util.Date;

public class ForumBean {
    private int id=0;
	private String title = null;
	private String contents = null;
	private String classification = null;
	private String sender = null;
    private Date sendtime=null;
	public ForumBean() {
		super();
	}
	
	



	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public ForumBean(int id, String title, String contents, String classification, String sender, Date sendtim) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.classification = classification;
		this.sender = sender;
		this.sendtime = sendtim;
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

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Date getSendtime() {
		return sendtime;
	}

	public void setSendtime(Date sendtim) {
		this.sendtime = sendtim;
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
