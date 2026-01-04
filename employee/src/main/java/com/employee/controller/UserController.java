package com.employee.controller;
import com.employee.entity.SystemUsers;
import com.employee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/v1/systemusers")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<SystemUsers>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SystemUsers> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }


    @PostMapping
    public ResponseEntity<SystemUsers> createUser(@RequestBody SystemUsers systemUsers) {
        return ResponseEntity.ok(userService.createUser(systemUsers));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SystemUsers> updateUser(@PathVariable Integer id, @RequestBody SystemUsers systemUsers) {

        systemUsers.setId(id);
        SystemUsers updatedUser = userService.updateUser(systemUsers);

        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.deleteuSER(id));
    }

}
