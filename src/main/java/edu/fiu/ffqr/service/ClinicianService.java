package edu.fiu.ffqr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.fiu.ffqr.models.SysUser;
import edu.fiu.ffqr.models.User;
import edu.fiu.ffqr.repositories.UsersRepository;
import edu.fiu.ffqr.service.UserService;
import edu.fiu.ffqr.models.Clinician;
import edu.fiu.ffqr.repositories.ClinicianRepository;

@Service
@Component
public class ClinicianService {

	@Autowired
	private ClinicianRepository clinicianRepository;
	
	public List<Clinician> getAll()	{
		return clinicianRepository.findAll();
	}
	
	public Clinician getClinicianByUsername(String username) {
		return clinicianRepository.findByUsername(username);
	}
	
	public Clinician getClinicianByClinicianId(String clinicianId) {
		return clinicianRepository.getByClinicianId(clinicianId);
	}
	
	public Clinician create(Clinician user) {
		return clinicianRepository.save(user);
	}
	
	public void delete(String userName) {
		Clinician fi = clinicianRepository.findByUsername(userName);
		clinicianRepository.delete(fi);
	}

	public void deleteById(String clinicianId) {
		Clinician fi = clinicianRepository.getByClinicianId(clinicianId);
		clinicianRepository.delete(fi);
	}
	
}
