package com.techguide.ticketsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @Column(nullable = false)
    private String status;
    
    @Column(name = "comp_id")
    private String compId;

    // Construtores
    public Ticket() {}

    public Ticket(String title, String description, User user, String status) {
        this.title = title;
        this.description = description;
        this.user = user;
        this.status = status;
        generateCompId();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        generateCompId();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    // Método para gerar o CompId automaticamente
    private void generateCompId() {
        if (user != null && user.getDepartment() != null && id != null) {
            this.compId = user.getDepartment().getCode() + " - " + id;
        }
    }

    // Método chamado após persistir no banco (para gerar CompId com ID válido)
    @PostPersist
    @PostUpdate
    private void updateCompId() {
        generateCompId();
    }
}
