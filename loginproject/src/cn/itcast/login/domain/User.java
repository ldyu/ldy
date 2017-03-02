package cn.itcast.login.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String id;
	private String username;
	private String password;
	

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}