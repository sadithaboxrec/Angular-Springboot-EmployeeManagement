package com.employee.service;

import com.employee.entity.SystemUsers;

import java.util.List;

public interface UserService {

    List<SystemUsers> getAllUsers();

    SystemUsers getUserById(Integer id);

    SystemUsers createUser(SystemUsers systemUsers);

    SystemUsers updateUser(SystemUsers systemUsers);

    String deleteuSER(Integer id);

}

