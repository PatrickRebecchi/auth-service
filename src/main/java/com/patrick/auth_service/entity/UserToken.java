package com.patrick.auth_service.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.Token;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "tokens")
public class UserToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String token;

    @Enumerated(EnumType.STRING)
    private TokenType type;

    private LocalDateTime expirationDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;


}
