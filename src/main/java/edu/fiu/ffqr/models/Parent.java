package edu.fiu.ffqr.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import edu.fiu.ffqr.models.User;
import edu.fiu.ffqr.models.Clinician;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="parents")
public class Parent{

	@JsonProperty("parentId")
	private String parentId; 
	@JsonProperty("username")
	private String username;
	@JsonProperty("userpassword")
    private String userpassword;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
	private String lastname;
	@JsonProperty("assignedclinician")
    private String assignedClinician;

	public Parent() {}
	
	public Parent(String parentId, String username, String firstname, String lastname, String userpassword, boolean isEnabled, String assignedClinician){
        this.parentId = parentId;
		this.username = username;
		this.userpassword = userpassword;
        this.firstname = firstname;
        this.lastname = lastname;
        this.assignedClinician = assignedClinician;

    }
	
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getUsername() {
		return username;
    }
    
    public String getFullname() {
        return (this.firstname + " " + this.lastname);
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getAssignedClinician() {
        return this.assignedClinician;
    }
    public void setAssignedClinician(String assignedClinician) {
        this.assignedClinician = assignedClinician;
            
    }

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String userpassword){
		this.userpassword = userpassword;
	}



}
