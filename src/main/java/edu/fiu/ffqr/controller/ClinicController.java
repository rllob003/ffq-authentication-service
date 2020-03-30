package edu.fiu.ffqr.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import edu.fiu.ffqr.FFQUserApplication;
import edu.fiu.ffqr.controller.UserController;
import edu.fiu.ffqr.models.Clinic;
import edu.fiu.ffqr.models.Clinician;
import edu.fiu.ffqr.models.SysUser;
import edu.fiu.ffqr.models.User;
import edu.fiu.ffqr.service.SysUserService;
import edu.fiu.ffqr.service.UserService;
import edu.fiu.ffqr.service.ClinicService;
import edu.fiu.ffqr.service.ClinicianService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/clinics")
public class ClinicController{

    @Autowired
    private ClinicService clinicService;


    public ClinicController() {
    }
    
    @GetMapping("/all")
    public List<Clinic> allClinics() throws JsonProcessingException {
        
        List<Clinic> clinics = clinicService.getAll();
        return clinics;
    }  

    @GetMapping("/{clinicID}")
	public Clinic getClinic(@PathVariable("clinicID") int clinicId) {
		return clinicService.getClinicByClinicId(clinicId);
	}
    
    @PostMapping("/createclinic")
    public Clinic createClinic(@RequestBody Clinic clinic) throws JsonProcessingException {

      if (clinicService.getClinicByClinicId(clinic.getClinicId()) != null) {
            throw new IllegalArgumentException("A user with Username " + clinic.getClinicId() + " already exists");
      }  
	  return clinicService.create(clinic);
	  
  }

  @PostMapping("/updateclinic")
    public Clinic updateClinic(@RequestBody Clinic clinic) throws JsonProcessingException {
        
        if (clinicService.getClinicByClinicId(clinic.getClinicId()) == null) {
            throw new IllegalArgumentException("A user with Username " + clinic.getClinicId() + " doesn't exist");
        }

        return clinicService.create(clinic);
    }


    @PostMapping("/create")
    public Clinic create(@RequestBody Clinic item) throws JsonProcessingException {
        
        if (clinicService.getClinicByClinicId(item.getClinicId()) != null) {
            throw new IllegalArgumentException("A clinic with userId " + item.getClinicId() + " already exists");
        }

        return clinicService.create(item);
    }

    
    
   
	
	@PostMapping("/createMany")
	public ArrayList<Clinic> create(@RequestBody ArrayList<Clinic> clinics) {
		Clinic clinic = null;
		
		for(Clinic s : clinics)
		{
			clinic = clinicService.create(s);
		}
		
		return clinics;
	}
	
	  
	  
	  @DeleteMapping("/delete")
	  public String delete(@RequestParam int clinicId) {
        clinicService.delete(clinicId);
	  	  return "Deleted " + clinicId;
	  }
	
}
