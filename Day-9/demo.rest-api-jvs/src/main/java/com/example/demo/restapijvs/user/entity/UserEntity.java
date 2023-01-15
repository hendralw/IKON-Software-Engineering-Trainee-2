package com.example.demo.restapijvs.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "springboot_user_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "id")
    @Getter
    @Setter
    private int id;
    @Column(name = "name")
    @Getter
    @Setter
    @NotNull(message = "name must not be null")
    @NotBlank(message = "name must not be blank")
    private String name;
    @Column(name = "email")
    @Getter
    @Setter
    @NotNull(message = "email must not be null")
    @NotBlank(message = "email must not be blank")
    private String email;
    @Column(name = "password")
    @Getter
    @Setter
    @NotNull(message = "password must not be null")
    @NotBlank(message = "password must not be blank")
    private String password;
}
