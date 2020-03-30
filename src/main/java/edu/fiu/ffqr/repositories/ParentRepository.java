package edu.fiu.ffqr.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import edu.fiu.ffqr.models.User;
import edu.fiu.ffqr.models.Parent;
import edu.fiu.ffqr.models.Clinician;

@Repository
public interface ParentRepository extends MongoRepository<Parent, String> {

    Parent getByParentId(int parentId);
	
    Parent findByUsername(String username);
  
    
}