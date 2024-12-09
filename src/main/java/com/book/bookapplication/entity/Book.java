package com.book.bookapplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "quatity", nullable = false)
    private int quantity;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "category_id", nullable = false)
    private int category_id;

    @Column(name = "author_id", nullable = false)
    private int author_id;


    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author author;


}
