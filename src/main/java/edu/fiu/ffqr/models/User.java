package edu.fiu.ffqr.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="users")
public class User implements Serializable {

	@JsonProperty("userId")
	private String userId; 
	@JsonProperty("username")
	private String username;
	@JsonProperty("userpassword")
	private String userpassword;
	@JsonProperty("isEnabled")
	private  boolean isEnabled;
	@JsonProperty("isClinician")
	private boolean isClinician;
	@JsonProperty("isParent")
	private boolean isParent;
	@JsonProperty("isAdmin")
	private boolean isAdmin;

	public User() {}
	
	public User(String userId, String username, String userpassword, boolean isEnabled, boolean isAdmin){
        this.userId = userId;
		this.username = username;
		this.userpassword = userpassword;
		this.isEnabled = isEnabled;
		this.isAdmin = isAdmin;

    }
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String userpassword){
		this.userpassword = userpassword;
	}

	public boolean getIsClinician(){
		return this.isClinician;
	}

	public void setIsClinician(boolean isClinician){
		this.isClinician = isClinician;
	}

	public boolean getIsParent(){
		return this.isParent;
	}
	public void setIsParent(boolean isParent){
		this.isParent = isParent;
	}

	public boolean getIsAdmin(){
		return this.isAdmin;
	}


}
