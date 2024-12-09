package com.book.bookapplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int author_id;

    @Column(name = "author_name", nullable = false)
    private String authorName;

    @Column(name = "description", nullable = false)
    private String description;


}
