package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Book;
import com.example.demo.repo.bookrepo;
import java.util.List;

@RestController
@RequestMapping("/book")
public class bookController {

    @Autowired
    private bookrepo bookRepo;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    @GetMapping
    public List<Book> listBooks() {
        return bookRepo.findAll();
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {

        Book existingBook = bookRepo.findById(id).orElse(null);

        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            return bookRepo.save(existingBook);
        }

        return null;
    }
    // @DeleteMapping("/{id}")
    // public void Delete(@PathVariable Long id) {
    // bookRepo.findById(id);
    // }

    // or we can do by providing string to delete

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        if (bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
            return "Book deleted successfully";
        }
        return "Book not found";
    }

}
