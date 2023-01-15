package com.example.demo.restapijvs.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
/*This is used as DTO
 * JsonResponse*/
public class UserModel {
    private int id;
    private String name;
    private String email;
    //private String password;
}
