package com.book.bookapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    private int id;

    @Column(name = "author_name", nullable = false)
    @NotBlank(message = "không được để trống phần này!")
    private String authorName;

    @Column(name = "description", nullable = false)
    @NotBlank(message = "không được để trống phần này!")
    private String description;


}
