package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Book;
import com.example.demo.repo.bookrepo;

@RestController
@RequestMapping("/book")
public class bookController {

    @Autowired
    private bookrepo bookRepo;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    public Book update(@RequestBody Book book){
        return bookRepo.up
    }

}
