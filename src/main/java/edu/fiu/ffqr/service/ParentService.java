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
import edu.fiu.ffqr.repositories.ParentRepository;
import edu.fiu.ffqr.repositories.UsersRepository;
import edu.fiu.ffqr.models.Parent;

@Service
@Component
public class ParentService {

	@Autowired
	private ParentRepository parentRepository;
	
	public List<Parent> getAll()	{
		return parentRepository.findAll();
	}
	
	public Parent getParentByUsername(String username) {
		return parentRepository.findByUsername(username);
	}
	
	public Parent getParentByParentId(String parentId) {
		return parentRepository.getByParentId(parentId);
	}
	
	public Parent create(Parent user) {
		return parentRepository.save(user);
	}
	
	public void delete(String userName) {
		Parent fi = parentRepository.findByUsername(userName);
		parentRepository.delete(fi);
	}

	public void deleteById(String parentId) {
		Parent fi = parentRepository.getByParentId(parentId);
		parentRepository.delete(fi);
	}
	
}
