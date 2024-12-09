package com.book.bookapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/author")
public class AuthorController {
    @GetMapping
    public String showFormAuthor() {
        return "admin-author";
    }
}
