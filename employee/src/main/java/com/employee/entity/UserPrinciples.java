package com.employee.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserPrinciples implements UserDetails {

    private SystemUsers  systemUsers;

    public UserPrinciples(SystemUsers systemUsers) {
        this.systemUsers = systemUsers;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // This maps your DB role (e.g., "MANAGER") to "ROLE_MANAGER"
        // Spring Security expects the "ROLE_" prefix for hasRole() checks
        return List.of(new SimpleGrantedAuthority("ROLE_" + systemUsers.getRole()));
        //return List.of(new SimpleGrantedAuthority(systemUsers.getRole()));
    }

    @Override
    public  String getPassword() {
        System.out.println("DEBUG: Password retrieved from DB for comparison: " + systemUsers.getPassword());
        return systemUsers.getPassword();
    }

    @Override
    public String getUsername() {
        return systemUsers.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}

