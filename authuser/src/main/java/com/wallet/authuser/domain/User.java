package com.wallet.authuser.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wallet.authuser.enums.UserStatus;
import com.wallet.authuser.enums.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "TB_USER")
public class User {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "USERNAME", nullable = false, unique = true, length = 50)
    private String username;
    @JsonIgnore
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "EMAIL", nullable = false, unique = true, length = 50)
    private String email;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "IMAGE_URL")
    private String imageUrl;
    @Column(name = "CPF", nullable = false)
    private String cpf;
    @Column(name = "FULLNAME", length = 15)
    private String fullname;
    @Column(name = "USER_TYPE")
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Column(name = "USER_STATUS")
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "CREATED_DATE")
    @CreationTimestamp
    private LocalDateTime createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "UPDATED_DATE")
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
