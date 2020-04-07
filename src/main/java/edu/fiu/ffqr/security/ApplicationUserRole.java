/*package edu.fiu.ffqr.security;

import com.google.common.collect.Sets;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static edu.fiu.ffqr.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    PARENT(Sets.newHashSet(VIEW_USER)),
    ADMIN(Sets.newHashSet(ADD_USER, DELETE_USER)),
    CLINICIAN(Sets.newHashSet(MODIFY_USER, GET_USER));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions){
        this.permissions = permissions;

    }

    public Set<ApplicationUserPermission> getPermissions() {
        return this.permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){

        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
                
    }

}*/