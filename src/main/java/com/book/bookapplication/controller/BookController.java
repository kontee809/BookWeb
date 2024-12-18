package com.book.bookapplication.controller;

import com.book.bookapplication.entity.Book;
import com.book.bookapplication.service.AuthorService;
import com.book.bookapplication.service.BookService;
import com.book.bookapplication.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/admin/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("{category_id}")
    public String showFormBookByCategoryId(Model model, @PathVariable int category_id) {
        model.addAttribute("list_books_by_category_id", bookService.getBooksByCategoryId(category_id));
        return "admin-books";
    }

    @GetMapping("/add-book")
    public String showFormAddBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("list_author", authorService.getAllAuthor());
        model.addAttribute("list_category", categoryService.findAllCategory());
        return "admin-add-book";
    }

    @PostMapping("/add-book/save")
    public String addBook(@ModelAttribute("book") @Valid Book book,
                          @RequestParam("imageFile") MultipartFile file,
                          BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "admin-add-book";
        }

        try {
            bookService.saveBook(book, file);
        } catch (IOException e) {
            model.addAttribute("error", "Khong tai duoc anh");
        }
        // Kiểm tra xem redirectUrl có tồn tại không, nếu có thì redirect đến đó, nếu không thì về trang admin-books
        return "redirect:/admin/category";
    }


}
