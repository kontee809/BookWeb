package com.book.bookapplication.service;

import com.book.bookapplication.entity.Book;
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
}
