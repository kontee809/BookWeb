package com.book.bookapplication.controller;

import com.book.bookapplication.entity.Category;
import com.book.bookapplication.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public String showFormCategory(Model model) {
        model.addAttribute("category_list", categoryService.findAllCategory());
        return "admin-category";
    }

    @GetMapping("/add-category")
    public String showFormAddCategory(Model model) {
        model.addAttribute("add_category", new Category());
        return "admin-add-category";
    }

    @PostMapping("/add-category/save")
    public String addCategory(@ModelAttribute("add_category") @Valid Category category,
                              BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "admin-add-category";
        }
        categoryService.addCategory(category);
        return "redirect:/admin/category";
    }

    @GetMapping("/{category_id}")
    public String deleteCategory(@PathVariable("category_id") int category_id) {
        categoryService.deleteCategoryById(category_id);
        return "redirect:/admin/category";
    }


}
