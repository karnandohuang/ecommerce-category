package com.training.magang.ecommerce.category.service.impl;

import com.training.magang.ecommerce.category.model.Category;
import com.training.magang.ecommerce.category.repository.CategoryRepository;
import com.training.magang.ecommerce.category.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Mono<Category> create(Category category) {

        return categoryRepository.save(category);
    }

    @Override
    public Mono<Category> findById(Long id) {

        return categoryRepository.findById(id);

    }

    @Override
    public Flux<Category> findAll() {

        return categoryRepository.findAll();

    }

    @Override
    public Mono<Category> update(Category category) {

        return findById(category.getId())
                .map(category1 -> new Category(category.getId(), category.getName()))
                .flatMap(category1 -> categoryRepository.save(category1));

    }

    @Override
    public Mono<Category> delete(Long id) {

        return this.categoryRepository
                .findById(id)
                .flatMap(p -> this.categoryRepository.deleteById(id));
    }
}
