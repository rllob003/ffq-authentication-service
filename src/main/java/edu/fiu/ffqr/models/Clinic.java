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
	@JsonProperty("datebuilt")
    private String dateBuilt;

	public Clinic() {}
	
	public Clinic(ObjectId clinicId, String address, String dateBuilt){
        this.clinicId = clinicId;
		this.address = address;
		this.dateBuilt = dateBuilt;
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
    public void getBuilddate(String dateBuilt) {
        this.dateBuilt = dateBuilt;
    }


}
