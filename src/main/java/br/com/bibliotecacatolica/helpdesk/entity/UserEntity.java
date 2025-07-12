package br.com.bibliotecacatolica.helpdesk.entity;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import br.com.bibliotecacatolica.helpdesk.dto.UserDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    public UserEntity() {
    }

    public UserEntity(UserDTO user) {
        BeanUtils.copyProperties(user, this);        
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;
    // private Department departmentId;
    // private int roleId;


    public String getName() {
        return name;
    }

    public void setName (String name){
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
    
    public boolean passwordReset(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UserEntity other = (UserEntity) obj;
        return Objects.equals(id, other.id);
    }
}
