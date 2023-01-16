package com.example.demo.restapijvs.product.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestModel {
    private int id;
    @NotNull(message = "name must not be null")
    @NotBlank(message = "name must not be blank")
    private String name;
}
