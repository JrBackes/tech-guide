package com.techguide.ticketsystem.config;

import com.techguide.ticketsystem.entity.Department;
import com.techguide.ticketsystem.entity.Ticket;
import com.techguide.ticketsystem.entity.User;
import com.techguide.ticketsystem.repository.DepartmentRepository;
import com.techguide.ticketsystem.repository.TicketRepository;
import com.techguide.ticketsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void run(String... args) throws Exception {
        // Criar departamentos
        Department techDepartment = new Department("Tecnologia", "TEC");
        Department supportDepartment = new Department("Atendimento", "ATD");
        
        departmentRepository.save(techDepartment);
        departmentRepository.save(supportDepartment);

        // Criar usuários
        User junior = new User("Junior Backes", "junior.backes@hotmail.com", "password123", techDepartment);
        User junior2 = new User("Junior Backes 2", "junior2.backes@hotmail.com", "password123", supportDepartment);
        
        userRepository.save(junior);
        userRepository.save(junior2);

        // Criar tickets
        Ticket ticket1 = new Ticket("Problema de Login", "Não consigo acessar minha conta", junior, "Aberto");
        Ticket ticket2 = new Ticket("Problema de Login", "Não consigo acessar minha conta", junior2, "Aberto");
        
        ticketRepository.save(ticket1);
        ticketRepository.save(ticket2);

        System.out.println("=== DADOS INICIALIZADOS ===");
        System.out.println("Ticket 1 CompId: " + ticket1.getCompId());
        System.out.println("Ticket 2 CompId: " + ticket2.getCompId());
    }
}
