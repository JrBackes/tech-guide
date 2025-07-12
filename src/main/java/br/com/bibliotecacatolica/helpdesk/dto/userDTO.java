package br.com.bibliotecacatolica.helpdesk.dto;

import org.springframework.beans.BeanUtils;

import br.com.bibliotecacatolica.helpdesk.entity.UserEntity;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;


    public UserDTO() {
    }

    public UserDTO(UserEntity user) {
        BeanUtils.copyProperties(user, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}