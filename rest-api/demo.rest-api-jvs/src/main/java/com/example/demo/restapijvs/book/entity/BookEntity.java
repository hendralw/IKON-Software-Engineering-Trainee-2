package com.example.demo.restapijvs.book.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@RedisHash("Book")
public class BookEntity implements Serializable {
    @Id
    private int id;
    private String isbn;
    private String judul;
    private String penulis;
    private String deskripsi;
    private String kategori;
}
