package edu.fiu.ffqr.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.fiu.ffqr.models.User;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="clinics")
public class Clinic implements Serializable {

	@JsonProperty("clinicId")
	private int clinicId; 
	@JsonProperty("address")
	private String address;
	@JsonProperty("datebuilt")
	private String dateBuilt;
	@JsonProperty("clinicName")
	private String clinicName;

	public Clinic() {}
	
	public Clinic(int clinicId, String address, String dateBuilt, String clinicName){
        this.clinicId = clinicId;
		this.address = address;
		this.dateBuilt = dateBuilt;
		this.clinicName = clinicName;
    }
	
	public int getClinicId() {
		return clinicId;
	}

	public void setClinicianId(int clinicId) {
		this.clinicId = clinicId;
	}

	public String getAddress() {
		return this.address;
    }
    
    public void setAdress(String address) {
        this.address = address;
    }
    public String getDateBuilt() {
        return this.dateBuilt;
	}
	public void setDateBuilt(String dateBuilt) {
        this.dateBuilt = dateBuilt;
	}

	public String getClinicName() {
		return this.clinicName;
	}   
    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }


}
