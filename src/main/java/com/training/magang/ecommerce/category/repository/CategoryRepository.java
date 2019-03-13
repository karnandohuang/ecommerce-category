package com.training.magang.ecommerce.category.repository;

import com.training.magang.ecommerce.category.model.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {

    Mono<Category> findById(Long id);

    Mono<Category> deleteById(Long id);

}
