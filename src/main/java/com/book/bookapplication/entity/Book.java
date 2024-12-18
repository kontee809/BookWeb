package com.book.bookapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private int id;

    @Column(name = "book_name", nullable = false)
    @NotBlank(message = "Vui lòng điền mục này!")
    private String bookName;

    @Column(name = "price", nullable = false)
    @NotNull(message = "Vui lòng điền mục này!")
    private double price;

    @Column(name = "quantity", nullable = false)
    @NotNull(message = "Vui lòng điền mục này!")
    private int quantity;

    @Column(name = "description", nullable = false)
    @NotBlank(message = "Vui lòng điền mục này!")
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
