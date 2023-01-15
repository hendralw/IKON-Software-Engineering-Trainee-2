package com.example.demo.restapijvs.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "springboot_user_tbl")
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "id")
    @Getter
    @Setter
    private int id;
    @Column(name = "name")
    @Getter
    @Setter
    private String name;
    @Column(name = "email")
    @Getter
    @Setter
    private String email;
    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    public UserEntity(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
