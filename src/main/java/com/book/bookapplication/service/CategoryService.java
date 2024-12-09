package com.book.bookapplication.service;

import com.book.bookapplication.entity.Category;
import com.book.bookapplication.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategoryById(int category_id) {
        categoryRepository.deleteById(category_id);
    }

}
