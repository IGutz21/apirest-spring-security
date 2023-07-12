package com.paqtafood.services;

import com.paqtafood.models.Category;
import com.paqtafood.models.Product;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    Category update(Long id, Category category);
    void deleteById(Long id);
}
