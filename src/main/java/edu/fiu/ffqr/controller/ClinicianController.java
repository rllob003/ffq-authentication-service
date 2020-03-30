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
import edu.fiu.ffqr.models.Clinician;
import edu.fiu.ffqr.models.SysUser;
import edu.fiu.ffqr.models.User;
import edu.fiu.ffqr.service.SysUserService;
import edu.fiu.ffqr.service.UserService;
import edu.fiu.ffqr.service.ClinicianService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/clinicians")
public class ClinicianController{

    @Autowired
    private ClinicianService clinicianService;


    public ClinicianController() {
    }
    
    @GetMapping("/all")
    public List<Clinician> allClinicians() throws JsonProcessingException {
        
        List<Clinician> users = clinicianService.getAll();
        return users;
    }  

    @GetMapping("/{clinicianID}")
	public Clinician getClinician(@PathVariable("clinicianID") int clinicianId) {
		return clinicianService.getClinicianByClinicianId(clinicianId);
	}
    
    @PostMapping("/createclinician")
    public Clinician createUser(@RequestBody Clinician user) throws JsonProcessingException {

      if (clinicianService.getClinicianByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("A user with Username " + user.getUsername() + " already exists");
      }  
	  return clinicianService.create(user);
	  
  }

  @PostMapping("/updateclinician")
    public Clinician updateUser(@RequestBody Clinician user) throws JsonProcessingException {
        
        if (clinicianService.getClinicianByUsername(user.getUsername()) == null) {
            throw new IllegalArgumentException("A user with Username " + user.getUsername() + " doesn't exist");
        }

        return clinicianService.create(user);
    }


    @PostMapping("/create")
    public Clinician create(@RequestBody Clinician item) throws JsonProcessingException {
        
        if (clinicianService.getClinicianByUsername(item.getUsername()) != null) {
            throw new IllegalArgumentException("A clinician with Username " + item.getUsername() + " already exists");
        }

        return clinicianService.create(item);
    }

    
    
   
	
	@PostMapping("/createMany")
	public ArrayList<Clinician> create(@RequestBody ArrayList<Clinician> users) {
		Clinician user = null;
		
		for(Clinician s : users)
		{
			user = clinicianService.create(s);
		}
		
		return users;
	}
	
	  
	  
	  @DeleteMapping("/delete")
	  public String delete(@RequestParam String username) {
        clinicianService.delete(username);
	  	  return "Deleted " + username;
	  }
	
}
