package edu.fiu.ffqr.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import edu.fiu.ffqr.models.User;

@Repository
public interface UsersRepository extends MongoRepository<User, String> {

  User getByUserId(String userId);
	
  User findByUsername(String username);

 // List<User> getAdmins(boolean isAdmin);
  
    
}