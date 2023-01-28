package com.example.demo.restapijvs.book.controller;

import com.example.demo.restapijvs.book.BookRepository;
import com.example.demo.restapijvs.book.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableCaching
@RequestMapping()
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/books")
    public BookEntity save (@RequestBody BookEntity book)
    {
        return bookRepository.save(book);
    }

    @GetMapping("/books")
    public List<BookEntity> getAllBooks()
    {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    @Cacheable(key = "#id", value = "Book")
    public BookEntity findBook(@PathVariable int id) {
        return bookRepository.findBookById(id);
    }

    @PutMapping("/books/{id}")
    public BookEntity update(@PathVariable int id, @RequestBody BookEntity book){
        return bookRepository.update(id,book);
    }

    @DeleteMapping("/books/{id}")
    @CacheEvict(key = "#id",value = "Book")
    public String remove(@PathVariable int id) {
        return bookRepository.deleteBook(id);
    }
}
