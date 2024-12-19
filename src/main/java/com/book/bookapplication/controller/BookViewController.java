package com.book.bookapplication.controller;

import com.book.bookapplication.service.BookService;
import com.book.bookapplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book-view")
public class BookViewController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookService bookService;

    @GetMapping("/{category_id}")
    public String showBook(@PathVariable("category_id") int category_id, Model model) {
        model.addAttribute("category_list", categoryService.findAllCategory());
        model.addAttribute("get_book_by_category_id", bookService.getBooksByCategoryId(category_id));
        return "book-view";
    }

    @GetMapping("/book-page/{book_id}")
    public String showBookDetail(@PathVariable("book_id") int book_id, Model model) {
        model.addAttribute("category_list", categoryService.findAllCategory());
        model.addAttribute("book_detail", bookService.getBookById(book_id));
        return "book-page";
    }

}
