package de.hsw.jee.guestbook01;

import java.util.Date;

public class GuestbookEntry{
	
	private String username;
	private String title;
	private String message;
	private Date dateCreated;
	
	public GuestbookEntry(String username, String title, String message) {
		this.username = username;
		this.title = title;
		this.message = message;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}