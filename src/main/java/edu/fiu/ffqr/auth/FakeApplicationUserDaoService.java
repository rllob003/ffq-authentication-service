/*package edu.fiu.ffqr.auth;

import edu.fiu.ffqr.security.ApplicationUserRole;
import edu.fiu.ffqr.user.User;
import com.google.common.collect.Lists;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;
    

    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
            .stream()
            .filter(applicationUser -> username.equals(applicationUser.getUsername()))
            .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
            new ApplicationUser(
                   "annasmith",
                    passwordEncoder.encode("password"),
                    ApplicationUserRole.PARENT.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            ),
            new ApplicationUser(
                   "linda",
                    passwordEncoder.encode("password"),
                    ApplicationUserRole.ADMIN.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            ),
            new ApplicationUser(
                   "tom",
                    passwordEncoder.encode("password"),
                    ApplicationUserRole.CLINICIAN.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            )

        );

        return applicationUsers;

    }



}*/