package com.techguide.ticketsystem.dto;

public class TicketDTO {
    private Long id;
    private String title;
    private String description;
    private UserDTO user;
    private String status;
    private String compId;

    public TicketDTO() {}

    public TicketDTO(Long id, String title, String description, UserDTO user, String status, String compId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
        this.status = status;
        this.compId = compId;
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
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
}
