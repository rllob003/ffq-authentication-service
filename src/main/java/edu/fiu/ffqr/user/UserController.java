package edu.fiu.ffqr.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/*import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController{


    private static final User user1 = new User(1, "James Bond");
    private static final User user2 = new User(2, "Maria Jones");
    private static final User user3 = new User(3, "Anna Smith");
    private static final List<User> USERS = Arrays.asList(
        user1, user2, user3
    );
       
        

    @GetMapping(path = "{userId}")
    public User getUser(@PathVariable("userId") Integer userId) {
        return USERS.stream().filter(user -> userId.equals(user.getUserId())).findFirst()
        .orElseThrow(() -> new IllegalStateException("User " + userId + " does not exist"));


    }

}*/