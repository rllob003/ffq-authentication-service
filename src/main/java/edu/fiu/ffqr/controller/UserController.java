package edu.fiu.ffqr.controller;

import java.util.ArrayList;
import java.util.List;

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
import edu.fiu.ffqr.models.SysUser;
import edu.fiu.ffqr.models.User;
import edu.fiu.ffqr.service.SysUserService;
import edu.fiu.ffqr.service.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    public UserController() {
    }
    
    @GetMapping("/all")
    public List<User> allUsers() throws JsonProcessingException {
        
        List<User> users = userService.getAll();
        return users;
    }  

    @GetMapping("/{userID}")
	public User gUserApplication(@PathVariable("userID") String userID) {
		return userService.getUserByUserId(userID);
	}
    
    @PostMapping("/createuser")
    public User createUser(@RequestBody User user) throws JsonProcessingException {

      if (userService.getUserByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("A user with Username " + user.getUsername() + " already exists");
      }  
	  return userService.create(user);
	  
  }

  @PostMapping("/updateuser")
    public User updateUser(@RequestBody User user) throws JsonProcessingException {
        
        if (userService.getUserByUsername(user.getUsername()) == null) {
            throw new IllegalArgumentException("A user with Username " + user.getUsername() + " doesn't exist");
        }

        return userService.create(user);
    }


    @PostMapping("/create")
    public User create(@RequestBody User item) throws JsonProcessingException {
        
        if (userService.getUserByUsername(item.getUsername()) != null) {
            throw new IllegalArgumentException("A user with Username " + item.getUsername() + " already exists");
        }

        return userService.create(item);
    }

    
    
   
	
	@PostMapping("/createMany")
	public ArrayList<User> create(@RequestBody ArrayList<User> users) {
		User user = null;
		
		for(User s : users)
		{
			user = userService.create(s);
		}
		
		return users;
	}
	
	  
	  
	  @DeleteMapping("/delete")
	  public String delete(@RequestParam String username) {
	      userService.delete(username);
	  	  return "Deleted " + username;
	  }
	
}
