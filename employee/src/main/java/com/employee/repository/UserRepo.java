package com.employee.repository;

import com.employee.entity.SystemUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<SystemUsers, Integer> {

    SystemUsers findByUsername(String username);
}
