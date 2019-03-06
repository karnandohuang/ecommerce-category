package com.training.magang.ecommerce.category.service;


import com.training.magang.ecommerce.category.model.Category;

import java.util.List;

public interface CategoryService {

    Category create(Category category);
    Category findById(int id);
    List<Category> findAll();
    Category update(Category category);
    Category delete(int id);

}
