package com.training.magang.ecommerce.category.service;


import com.training.magang.ecommerce.category.model.Category;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CategoryService {

    Mono<Category> create(Category category);
    Mono<Category> findById(Long id);
    Flux<Category> findAll();
    Mono<Category> update(Category category);
    Mono<Category> delete(Long id);

}
