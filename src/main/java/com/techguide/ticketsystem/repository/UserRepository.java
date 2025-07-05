package com.techguide.ticketsystem.repository;

import com.techguide.ticketsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    @Query("SELECT u FROM User u JOIN FETCH u.department")
    List<User> findAllWithDepartment();
    
    @Query("SELECT u FROM User u JOIN FETCH u.department WHERE u.id = :id")
    Optional<User> findByIdWithDepartment(Long id);
    
    Optional<User> findByEmail(String email);
    
    boolean existsByEmail(String email);
    
    List<User> findByDepartmentId(Long departmentId);
}
