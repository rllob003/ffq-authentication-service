package edu.fiu.ffqr.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import edu.fiu.ffqr.models.User;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="clinicians")
public class Clinician{

	@JsonProperty("clinicianId")
	private String clinicianId; 
	@JsonProperty("username")
	private String username;
	@JsonProperty("userpassword")
    private String userpassword;
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
	private String lastname;
    @JsonProperty("assignedclinic")
    private int assignedClinic;

	public Clinician() {}
	
	public Clinician(String clinicianId, String username, String firstname, String lastname, String userpassword, int assignedClinic){
        this.clinicianId = clinicianId;
		this.username = username;
		this.userpassword = userpassword;
        this.firstname = firstname;
        this.lastname = lastname;
        this.assignedClinic = assignedClinic;

    }
	
	public String getClinicianId() {
		return this.clinicianId;
	}

	public void setClinicianId(String clinicianId) {
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
