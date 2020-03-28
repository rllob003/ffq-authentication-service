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

@Service
@Component
public class UserService {

	@Autowired
	private UsersRepository usersRepository;
	
	public List<User> getAll()	{
		return usersRepository.findAll();
	}
	
	public User getUserByUsername(String username) {
		return usersRepository.findByUsername(username);
	}
	
	public User getUserByUserId(String userId) {
		return usersRepository.getByUserId(userId);
	}
	
	public User create(User user) {
		return usersRepository.save(user);
	}
	
	public void delete(String userName) {
		User fi = usersRepository.findByUsername(userName);
		usersRepository.delete(fi);
	}

	public void deleteById(String userId) {
		User fi = usersRepository.getByUserId(userId);
		usersRepository.delete(fi);
	}
	
}
