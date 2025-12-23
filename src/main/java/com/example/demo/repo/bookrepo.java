package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Book;

public interface bookrepo extends JpaRepository<Book ,Long> {

    
} 
