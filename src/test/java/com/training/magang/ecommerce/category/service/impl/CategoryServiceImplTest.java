//package com.training.magang.ecommerce.category.service.impl;
//
//import com.training.magang.ecommerce.category.model.Category;
//import com.training.magang.ecommerce.category.service.CategoryService;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class CategoryServiceImplTest {
//
//    @Autowired
//    private CategoryService categoryService;
//
//    @Test
//    public void createCategoryTest() {
//        Category category = new Category();
//        category.setName("Books");
//
//        categoryService.create(category);
//
//        Assert.assertTrue(categoryService.findAll().size() == 1);
//    }
//
//    @Test
//    public void findById() {
//        Category category = new Category();
//        category.setName("Books");
//
//        categoryService.create(category);
//
//        categoryService.findById(1L);
//
//        Assert.assertTrue(categoryService.findById(1L).equals(category));
//
//    }
//
//    @Test
//    public void findAll() {
//        Category category1 = new Category();
//        category1.setName("Books");
//
//        categoryService.create(category1);
//
//        Category category2 = new Category();
//        category2.setName("Electronics");
//
//        categoryService.create(category2);
//
//        List<Category> categoryList = new ArrayList<>();
//        categoryList.add(category1);
//        categoryList.add(category2);
//
//        Assert.assertEquals(categoryService.findAll(), categoryList);
//
//
//    }
//
//    @Test
//    public void update() {
//        Category category = new Category();
//        category.setName("Books");
//
//        categoryService.create(category);
//
//        category.setName("Electronics");
//        category.setId(1L);
//
//        categoryService.update(category);
//
//        Assert.assertEquals(categoryService.findById(1L), category);
//
//    }
//
//    @Test
//    public void delete() {
//
//        Category category = new Category();
//        category.setName("Books");
//
//        categoryService.create(category);
//
//        Assert.assertTrue(categoryService.findAll().size() == 1);
//
//        categoryService.delete(1L);
//
//        Assert.assertTrue(categoryService.findAll().size() == 0);
//
//    }
//}