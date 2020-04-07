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
import edu.fiu.ffqr.models.Clinic;
import edu.fiu.ffqr.models.Clinician;
import edu.fiu.ffqr.repositories.ClinicRepository;
import edu.fiu.ffqr.repositories.ClinicianRepository;

@Service
@Component
public class ClinicService {

	@Autowired
	private ClinicRepository clinicRepository;
	
	public List<Clinic> getAll()	{
		return clinicRepository.findAll();
	}
	
	public Clinic getClinicByClinicId(int clinicId) {
		return clinicRepository.getByClinicId(clinicId);
	}

	public Clinic getClinicByClinicName(String clinicName) {
		return clinicRepository.getByClinicName(clinicName);
	}
	
	public Clinic create(Clinic clinic) {
		return clinicRepository.save(clinic);
	}

	public void delete(int clinicId) {
		Clinic fi = clinicRepository.getByClinicId(clinicId);
		clinicRepository.delete(fi);
	}
	
}
