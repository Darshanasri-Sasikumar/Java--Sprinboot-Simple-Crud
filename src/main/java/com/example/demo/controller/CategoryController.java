package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.CategoryModel;
import java.util.*;
import com.example.demo.repo.CategoryRepo;
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepo repo;

    @PostMapping("/store")
    public  CategoryModel store(@RequestBody CategoryModel category){
        return repo.save(category);
    }

    @GetMapping("/get")
    public List<CategoryModel> listcategory(){
        return repo.findAll();

    }
    
}
