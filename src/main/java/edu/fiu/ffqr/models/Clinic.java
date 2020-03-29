package edu.fiu.ffqr.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.fiu.ffqr.models.User;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="clinics")
public class Clinic{

	@JsonProperty("clinicId")
	private ObjectId clinicId; 
	@JsonProperty("address")
	private String address;
	@JsonProperty("builddate")
    private String builddate;

	public Clinic() {}
	
	public Clinic(ObjectId clinicId, String address, String builddate){
        this.clinicId = clinicId;
		this.address = address;
		this.builddate = builddate;
    }
	
	public ObjectId getClinicId() {
		return clinicId;
	}

	public void setClinicianId(ObjectId clinicId) {
		this.clinicId = clinicId;
	}

	public String getAddress() {
		return this.address;
    }
    
    public void setAdress(String address) {
        this.address = address;
    }
    public void getBuilddate(String builddate) {
        this.builddate = builddate;
    }


}
