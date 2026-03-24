package com.patrick.auth_service.entity;

import com.patrick.auth_service.dto.RegisterDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotNull(message = "Age cannot be empty")
    @Min(value = 0, message = "Age must be positive")
    private Integer age;

    @Email(message = "Please enter a valid email address.")
    @NotBlank(message = "The email address cannot be empty.")
    @Column(unique = true)
    private String email;

    @NotBlank
    private String phone;

    @NotBlank(message = "password cannot be empty.")
    private String password;

    private boolean enabled; // vai ser criado como Null, pode ser ativado com o token que vai enviado pelo email

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserToken> userTokenList;

    @Transient
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public User (RegisterDTO dto){
        this.firstName = dto.firstName();
        this.lastName = dto.lastName();
        this.age = dto.age();
        this.phone = dto.phone();
        this.email = dto.email();
        this.enabled = false;
    }



}
