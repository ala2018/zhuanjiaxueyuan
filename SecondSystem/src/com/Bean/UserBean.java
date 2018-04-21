package com.Bean;
public class UserBean {
    private String user=null;
    private String sex=null;
    private String name=null;
    public UserBean() {
		super();
	}
	public UserBean(String user, String sex, String name) {
		this.user = user;
		this.sex = sex;
		this.name = name;
	}
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

