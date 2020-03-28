/*package edu.fiu.ffqr.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import edu.fiu.ffqr.security.ApplicationUserRole.*;

import java.util.concurrent.TimeUnit;

import edu.fiu.ffqr.auth.ApplicationUserService;
import edu.fiu.ffqr.security.ApplicationUserPermission;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    
    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService){
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
        http
//            .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//            .and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
            .antMatchers("/api/**").hasRole(ApplicationUserRole.PARENT.name())
            /*
            .antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
            .antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
            .antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
            .antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ApplicationUserRole.ADMIN.name(), ApplicationUserRole.ADMINTRAINEE.name())
            */
/*
            .anyRequest()
            .authenticated()
            .and()
            //.httpBasic();
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/courses", true)
//                .passwordParameter("password")               //parameters added to change the name (for all password, username, and remember-me)
//                .usernameParameter("username")
            .and()
            .rememberMe()
                .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21))  //defaults to 2 weeks
                .key("somethingverysecured")
//                .rememberMeParameter("remember-me")
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))  //Get ( use POST instead)
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")
                .logoutSuccessUrl("/login")
            ;

    }


    //@Override
    //@Bean
    //protected UserDetailsService userDetailsService() {
    protected UserDetailsService userDetailsService() {
        UserDetails annaSmithUser = User.builder()
                .username("annasmith")
                .password(passwordEncoder.encode("password123"))
     //           .roles(ApplicationUserRole.PARENT.name())   //ROLE_PARENT
                .authorities(ApplicationUserRole.PARENT.getGrantedAuthorities())
                .build();

        UserDetails lindaUser = User.builder()
                .username("linda")
                .password(passwordEncoder.encode("password123"))
        //        .roles(ApplicationUserRole.ADMIN.name())    //ROLE_ADMIN
        .authorities(ApplicationUserRole.ADMIN.getGrantedAuthorities())
                .build();

         UserDetails tomUser = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("password123"))
         //       .roles(ApplicationUserRole.ADMINTRAINEE.name())   //ROLE_ADMINTRAINEE
         .authorities(ApplicationUserRole.CLINICIAN.getGrantedAuthorities())
                .build();       
        return new InMemoryUserDetailsManager(
            annaSmithUser, 
            lindaUser,
            tomUser

        );

    }

    //Using repository
/*
   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
*/

/*
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder); 
        provider.setUserDetailsService(applicationUserService);
        return provider;

    }*/
/*
}*/