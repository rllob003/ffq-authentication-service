package edu.fiu.ffqr.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.fiu.ffqr.models.User;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="clinicians")
public class Clinician implements Serializable{

	@JsonProperty("clinicianId")
	private int clinicianId; 
	@JsonProperty("username")
	private String username;
	@JsonProperty("userpassword")
    private String userpassword;
    @JsonProperty("role")
    private String role;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
	private String lastname;
    @JsonProperty("assignedclinic")
    private int assignedClinic;

	public Clinician() {}
	
	public Clinician(int clinicianId, String username, String userpassword, String role, String firstname, String lastname, int assignedClinic){
        this.clinicianId = clinicianId;
		this.username = username;
        this.userpassword = userpassword;
        this.role = role;
        this.firstname = firstname;
        this.lastname = lastname;
        this.assignedClinic = assignedClinic;

    }
	
	public int getClinicianId() {
		return this.clinicianId;
	}

	public void setClinicianId(int clinicianId) {
		this.clinicianId = clinicianId;
	}

	public String getUsername() {
		return this.username;
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

    public int getAssignedClinic() {
        return this.assignedClinic;
    }
    public void setAssignedClinic(int assignedClinic) {
        this.assignedClinic = assignedClinic;
            
    }

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String userpassword){
		this.userpassword = userpassword;
	}



}
