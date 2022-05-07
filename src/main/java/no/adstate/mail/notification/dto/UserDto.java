package no.adstate.mail.notification.dto;

import java.io.Serializable;

public class UserDto implements Serializable{

	private static final long serialVersionUID = -3545100978344624849L;
	
	private String username;
	private String password;
	private String email;
	private String mailList;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMailList() {
		return mailList;
	}
	public void setMailList(String mailList) {
		this.mailList = mailList;
	}
	
}
