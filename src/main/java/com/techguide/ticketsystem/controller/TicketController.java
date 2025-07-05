package com.techguide.ticketsystem.controller;

import com.techguide.ticketsystem.dto.TicketDTO;
import com.techguide.ticketsystem.entity.Ticket;
import com.techguide.ticketsystem.entity.User;
import com.techguide.ticketsystem.repository.TicketRepository;
import com.techguide.ticketsystem.repository.UserRepository;
import com.techguide.ticketsystem.service.DTOConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DTOConverterService dtoConverter;

    @GetMapping
    public List<TicketDTO> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAllWithUserAndDepartment();
        return dtoConverter.convertTicketsToDTO(tickets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketRepository.findByIdWithUserAndDepartment(id);
        return ticket.map(t -> ResponseEntity.ok(dtoConverter.convertToDTO(t)))
                     .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TicketDTO>> getTicketsByUser(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            List<Ticket> tickets = ticketRepository.findByUser(user.get());
            return ResponseEntity.ok(dtoConverter.convertTicketsToDTO(tickets));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/status/{status}")
    public List<TicketDTO> getTicketsByStatus(@PathVariable String status) {
        List<Ticket> tickets = ticketRepository.findByStatusWithUserAndDepartment(status);
        return dtoConverter.convertTicketsToDTO(tickets);
    }

    @GetMapping("/department/{departmentCode}")
    public List<Ticket> getTicketsByDepartment(@PathVariable String departmentCode) {
        return ticketRepository.findByUserDepartmentCode(departmentCode);
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket savedTicket = ticketRepository.save(ticket);
        return ResponseEntity.ok(savedTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setTitle(ticketDetails.getTitle());
            ticket.setDescription(ticketDetails.getDescription());
            ticket.setStatus(ticketDetails.getStatus());
            Ticket updatedTicket = ticketRepository.save(ticket);
            return ResponseEntity.ok(updatedTicket);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
