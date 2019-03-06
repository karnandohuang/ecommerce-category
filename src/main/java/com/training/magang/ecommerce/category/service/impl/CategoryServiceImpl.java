package com.training.magang.ecommerce.category.service.impl;

import com.training.magang.ecommerce.category.model.Category;
import com.training.magang.ecommerce.category.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {

    ArrayList<Category> categories = new ArrayList<>();

    @Override
    public Category create(Category category) {

        categories.add(category);

        return category;
    }

    @Override
    public Category findById(int id) {

        for (Category category: categories) {
            if(category.getId() == id){
                return category;
            }
        }

        return null;
    }

    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public Category update(Category category) {

        for (Category cat: categories) {
            if(cat.getId() == category.getId()){
                BeanUtils.copyProperties(cat, category);
                return cat;
            }
        }

        return null;
    }

    @Override
    public Category delete(int id) {
        Category category = findById(id);

        categories.remove(category);

        return category;
    }
}
