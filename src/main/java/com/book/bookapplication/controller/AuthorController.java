package com.book.bookapplication.controller;

import com.book.bookapplication.entity.Author;
import com.book.bookapplication.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping()
    public String showFormAuthor(Model model) {
        model.addAttribute("author_list", authorService.getAllAuthor());
        return "admin-author";
    }

    @GetMapping("/add-author")
    public String showFormAddAuthor(Model model) {
        model.addAttribute("add_author", new Author());
        return "admin-add-author";
    }

    @PostMapping("/add-author/save")
    public String addAuthor(@ModelAttribute("add_author") @Valid Author author,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin-add-author";
        }
        authorService.addAuthor(author);
        return "redirect:/admin/author";
    }

    @GetMapping("/delete/{author_id}")
    public String deleteAuthor(@PathVariable("author_id") int author_id) {
        authorService.deleteAuthorById(author_id);
        return "redirect:/admin/author";
    }

    @GetMapping("/edit/{author_id}")
    public String editAuthor(@PathVariable("author_id") int author_id, Model model) {
        model.addAttribute("edit_author", authorService.getAuthorById(author_id));
        return "admin-edit-author";
    }

    @PostMapping("/update/save/{author_id}")
    public String updateAuthor(@PathVariable("author_id") int author_id,
                               @ModelAttribute("edit_author") @Valid Author author,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin-edit-author";
        }
        authorService.updateAuthor(author_id, author);
        return "redirect:/admin/author";
    }
}
