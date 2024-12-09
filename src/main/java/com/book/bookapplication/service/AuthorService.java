package com.book.bookapplication.service;

import com.book.bookapplication.entity.Author;
import com.book.bookapplication.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthorById(int author_id) {
        authorRepository.deleteById(author_id);
    }

    public Author getAuthorById(int author_id) {
        return authorRepository.findById(author_id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author id " + author_id));
    }

    public Author updateAuthor(int author_id, Author author) {
        Author existingAuthor = getAuthorById(author_id);
        existingAuthor.setAuthorName(author.getAuthorName());
        existingAuthor.setDescription(author.getDescription());

        return authorRepository.save(existingAuthor);
    }
}
