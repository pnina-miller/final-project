package com.wuwei.entity;

import javax.persistence.*;

@Entity
@Table(name = "SiteAuthentication")
public class SiteAuthentication {
    
	@Column(name = "SiteId")
	private String SiteId;
	@Column(name = "SiteUrl")
	private String SiteUrl;

	@ManyToOne
	@JoinColumn(name = "UserId")
    private User User;
	@Column(name = "UserName")
    private String UserName;
	@Column(name = "UserPassword")
    private String UserPassword;
	
	public String getSiteId() {
		return SiteId;
	}
	public void setSiteId(String siteId) {
		SiteId = siteId;
	}
	public String getSiteUrl() {
		return SiteUrl;
	}
	public void setSiteUrl(String siteUrl) {
		SiteUrl = siteUrl;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}



	
}
