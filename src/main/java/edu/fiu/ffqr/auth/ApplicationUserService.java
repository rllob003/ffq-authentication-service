/*package edu.fiu.ffqr.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service                                                                                    //So spring would initialize this class      
public class ApplicationUserService implements UserDetailsService {



    private final ApplicationUserDao applicationUserDao;

    @Autowired
    public ApplicationUserService(@Qualifier("fake") ApplicationUserDao applicationUserDao){   //Qualifier("fake") to use the fake Service
        this.applicationUserDao = applicationUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        return applicationUserDao
            .selectApplicationUserByUsername(username)
            .orElseThrow(() -> 
                new UsernameNotFoundException(String.format("Username %s not found", username)));
    }


    
}*/