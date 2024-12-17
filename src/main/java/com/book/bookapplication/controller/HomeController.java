package com.book.bookapplication.controller;

import com.book.bookapplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/home")
    public String Home(Model model) {
        model.addAttribute("category_list", categoryService.findAllCategory());
        System.out.println(categoryService.findAllCategory());
        return "index";
    }

    @GetMapping("/admin/dashboard")
    public String Dashboard() {
        return "admin-dashboard";
    }


}
