package com.employee.service;


import com.employee.entity.SystemUsers;
import com.employee.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<SystemUsers> getAllUsers() {
        return (List<SystemUsers>) userRepo.findAll();
    }

    @Override
    public SystemUsers getUserById(Integer id) {
        return userRepo.findById(id).get();
    }

    @Override
    public SystemUsers createUser(SystemUsers systemUsers) {

        systemUsers.setPassword(passwordEncoder.encode(systemUsers.getPassword()));
        return userRepo.save(systemUsers);
    }

    @Override
    public SystemUsers updateUser(SystemUsers systemUsers) {
        //  Check if the user exists
        if (userRepo.existsById(systemUsers.getId())) {
            SystemUsers userObj = userRepo.findById(systemUsers.getId()).get();
            //update fields
            userObj.setUsername(systemUsers.getUsername());
            userObj.setRole(systemUsers.getRole());

            // update password if a new password there
            if (systemUsers.getPassword() != null && !systemUsers.getPassword().isEmpty()) {
                userObj.setPassword(passwordEncoder.encode(systemUsers.getPassword()));
            }

            return userRepo.save(userObj);
        }

        return null;
    }

    @Override
    public String deleteuSER(Integer id) {
        String dltmsg = "User not found with id: " + id;

        if (userRepo.existsById(id)) {
            SystemUsers userObj = userRepo.findById(id).get();
            userRepo.delete(userObj);
            dltmsg = "User account deleted successfully for id: " + id;
        }

        return dltmsg;
    }
}
