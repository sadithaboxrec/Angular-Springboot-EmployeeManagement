package com.employee.service;

import com.employee.entity.SystemUsers;
import com.employee.entity.UserPrinciples;
import com.employee.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUsers systemUsers=userRepo.findByUsername(username);

        System.out.println("Trying to login with: " + username);
        System.out.println("User found in DB: " + (systemUsers != null));

        if(systemUsers==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }



        return new UserPrinciples(systemUsers);
    }


}
