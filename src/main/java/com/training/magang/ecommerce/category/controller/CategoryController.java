package com.training.magang.ecommerce.category.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.magang.ecommerce.category.model.Category;
import com.training.magang.ecommerce.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(
            value = "/categories",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Category> create(@RequestBody Category category){
        return categoryService.create(category).subscribeOn(Schedulers.elastic());
    }

    @RequestMapping(
            value = "/categories/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Category> findById(@PathVariable("id") Long id){
        return categoryService.findById(id).subscribeOn(Schedulers.elastic());
    }

    @RequestMapping(
            value = "/categories",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Category> findAll(){

        return categoryService.findAll().subscribeOn(Schedulers.elastic());
    }
//
    @RequestMapping(
            value = "/categories",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Category> update(@RequestBody Category category){

        return categoryService.update(category).subscribeOn(Schedulers.elastic());
    }

    @RequestMapping(
            value = "/categories/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Category> delete(@PathVariable("id") Long id){

        return categoryService.delete(id).subscribeOn(Schedulers.elastic());
    }

    @RequestMapping(
            value = "/categories/publish",
            method = RequestMethod.GET,
            consumes = MediaType.TEXT_PLAIN_VALUE
    )
    public String publish() throws JsonProcessingException {
        Category category = new Category(1L, "Hello World");


        String topic = "categories";
        String json = objectMapper.writeValueAsString(category);

        kafkaTemplate.send(topic, json);
        return "OK";
    }




}
