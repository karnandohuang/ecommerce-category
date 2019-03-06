package com.training.magang.ecommerce.category.controller;

import com.training.magang.ecommerce.category.model.Category;
import com.training.magang.ecommerce.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(
            value = "/categories",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @RequestMapping(
            value = "/categories/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Category findById(@PathVariable("id") int id){
        return categoryService.findById(id);
    }

    @RequestMapping(
            value = "/categories",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> findAll(){

        return categoryService.findAll();
    }
//
    @RequestMapping(
            value = "/categories",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Category update(@RequestBody Category category){

        return categoryService.update(category);
    }

    @RequestMapping(
            value = "/categories/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Category delete(@PathVariable("id") int id){

        return categoryService.delete(id);
    }



}
