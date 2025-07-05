package com.techguide.ticketsystem.controller;

import com.techguide.ticketsystem.dto.UserDTO;
import com.techguide.ticketsystem.entity.User;
import com.techguide.ticketsystem.repository.UserRepository;
import com.techguide.ticketsystem.service.DTOConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DTOConverterService dtoConverter;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAllWithDepartment();
        return dtoConverter.convertUsersToDTO(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findByIdWithDepartment(id);
        return user.map(u -> ResponseEntity.ok(dtoConverter.convertToDTO(u)))
                   .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(u -> ResponseEntity.ok(dtoConverter.convertToDTO(u)))
                   .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/department/{departmentId}")
    public List<UserDTO> getUsersByDepartment(@PathVariable Long departmentId) {
        List<User> users = userRepository.findByDepartmentId(departmentId);
        return dtoConverter.convertUsersToDTO(users);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return dtoConverter.convertToDTO(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setName(userDetails.getName());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPassword(userDetails.getPassword());
            existingUser.setDepartment(userDetails.getDepartment());
            existingUser.setRoleId(userDetails.getRoleId());
            
            User updatedUser = userRepository.save(existingUser);
            return ResponseEntity.ok(dtoConverter.convertToDTO(updatedUser));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
