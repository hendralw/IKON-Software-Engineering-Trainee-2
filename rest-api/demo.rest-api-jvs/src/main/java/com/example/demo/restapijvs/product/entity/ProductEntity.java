package com.example.demo.restapijvs.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "springboot_product_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @Column(name = "id")
    @Getter
    @Setter
    private int id;
    @Column(name = "name")
    @Getter
    @Setter
    private String name;
}