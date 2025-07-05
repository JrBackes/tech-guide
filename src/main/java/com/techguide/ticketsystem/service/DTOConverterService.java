package com.techguide.ticketsystem.service;

import com.techguide.ticketsystem.dto.DepartmentDTO;
import com.techguide.ticketsystem.dto.TicketDTO;
import com.techguide.ticketsystem.dto.UserDTO;
import com.techguide.ticketsystem.entity.Department;
import com.techguide.ticketsystem.entity.Ticket;
import com.techguide.ticketsystem.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DTOConverterService {

    public DepartmentDTO convertToDTO(Department department) {
        if (department == null) return null;
        return new DepartmentDTO(
            department.getId(),
            department.getName(),
            department.getCode()
        );
    }

    public UserDTO convertToDTO(User user) {
        if (user == null) return null;
        return new UserDTO(
            user.getId(),
            user.getName(),
            user.getEmail(),
            convertToDTO(user.getDepartment()),
            user.getRoleId()
        );
    }

    public TicketDTO convertToDTO(Ticket ticket) {
        if (ticket == null) return null;
        return new TicketDTO(
            ticket.getId(),
            ticket.getTitle(),
            ticket.getDescription(),
            convertToDTO(ticket.getUser()),
            ticket.getStatus(),
            ticket.getCompId()
        );
    }

    public List<DepartmentDTO> convertToDTO(List<Department> departments) {
        return departments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<UserDTO> convertUsersToDTO(List<User> users) {
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<TicketDTO> convertTicketsToDTO(List<Ticket> tickets) {
        return tickets.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
