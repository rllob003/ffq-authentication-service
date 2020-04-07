/*package edu.fiu.ffqr.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management/api/v1/users")
public class UserManagementController {



    private static final User user1 = new User(1, "James Bond");
    private static final User user2 = new User(2, "Maria Jones");
    private static final User user3 = new User(3, "Anna Smith");
    private static final List<User> USERS = Arrays.asList(
        user1, user2, user3
    );

//      hasRole('ROLE_')    hasAnyRole('ROLE_')    hasAuthority('permission')  hasAnyAuthority('permission')

    @GetMapping
    @PreAuthorize("hasAuthority('user:get')")
    public List<User> getAllUsers(){
        System.out.println("getAllUsers");
        return USERS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:add')")
    public void registerNewUser(@RequestBody User user){
        System.out.println("registerNewUser");
    }

    @DeleteMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('user:delete')")
    public void deleteUser(@PathVariable("userId") Integer userId){
        System.out.println("deleteUser");
    }

    @PutMapping(path = "{userId}")
    @PreAuthorize("hasAnyRole('ADD_USER', 'MODIFY_USER')")
    public void updateUser(@PathVariable("userId") Integer userId,@RequestBody User user){
        System.out.println(String.format("%s %s", userId, user));
    }
}*/