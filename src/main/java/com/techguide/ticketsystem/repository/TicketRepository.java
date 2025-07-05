package com.techguide.ticketsystem.repository;

import com.techguide.ticketsystem.entity.Ticket;
import com.techguide.ticketsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
    @Query("SELECT t FROM Ticket t JOIN FETCH t.user u JOIN FETCH u.department")
    List<Ticket> findAllWithUserAndDepartment();
    
    @Query("SELECT t FROM Ticket t JOIN FETCH t.user u JOIN FETCH u.department WHERE t.id = :id")
    Optional<Ticket> findByIdWithUserAndDepartment(Long id);
    
    @Query("SELECT t FROM Ticket t JOIN FETCH t.user u JOIN FETCH u.department WHERE t.status = :status")
    List<Ticket> findByStatusWithUserAndDepartment(String status);
    
    List<Ticket> findByUser(User user);
    
    List<Ticket> findByStatus(String status);
    
    List<Ticket> findByUserDepartmentCode(String departmentCode);
}
