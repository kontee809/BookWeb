package com.book.bookapplication.service;

import com.book.bookapplication.entity.Book;
import com.book.bookapplication.entity.Category;
import com.book.bookapplication.repository.BookRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private Cloudinary cloudinary;

    public List<Book> getBooksByCategoryId(int categoryId) {
        return bookRepository.findBookByCategoryId(categoryId);
    }

    public void saveBook(Book book, MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            book.setImage(uploadResult.get("url").toString());
        }
        bookRepository.save(book);
    }

    public void deleteBookById(int book_id) {
        bookRepository.deleteById(book_id);
    }

    public Book getBookById(int book_id) {
        return bookRepository.findById(book_id).orElse(null);
    }

    public void updateBook(int book_id, Book book, MultipartFile file) throws IOException {
        Book existingBook = getBookById(book_id);
        if (existingBook != null) {
            existingBook.setBookName(book.getBookName());
            existingBook.setAuthor_id(book.getAuthor_id());
            existingBook.setCategory_id(book.getCategory_id());
            existingBook.setQuantity(book.getQuantity());
            existingBook.setPrice(book.getPrice());
            existingBook.setDescription(book.getDescription());

            if (!file.isEmpty()) {
                Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                existingBook.setImage(uploadResult.get("url").toString());
            }

            bookRepository.save(existingBook);
        } else {
            throw new IllegalArgumentException("Book not found with ID: " + book_id);
        }
    }
}
