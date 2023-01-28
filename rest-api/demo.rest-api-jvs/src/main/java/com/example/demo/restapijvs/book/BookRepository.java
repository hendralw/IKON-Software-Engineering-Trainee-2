package com.example.demo.restapijvs.book;

import com.example.demo.restapijvs.book.entity.BookEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    public static final String HASH_KEY = "Book";

    @Autowired
    private RedisTemplate template;

    public BookEntity save(BookEntity book){
        template.opsForHash().put(HASH_KEY,book.getId(),book);
        return book;
    }

    public List<BookEntity> findAll(){
        System.out.println("called findAll from DB");
        return template.opsForHash().values(HASH_KEY);
    }

    public BookEntity findBookById(int id){
        System.out.println("called findBookById() from DB");
        return (BookEntity) template.opsForHash().get(HASH_KEY,id);
    }

    public BookEntity update(int id , @NotNull BookEntity book){
        book.setId(id);
        template.opsForHash().put(HASH_KEY,book.getId(),book);
        return book;
    }

    public String deleteBook(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "book removed !!";
    }
}
