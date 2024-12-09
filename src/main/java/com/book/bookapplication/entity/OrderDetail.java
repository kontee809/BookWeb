package com.book.bookapplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_detail_id;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "order_id", nullable = false)
    private int order_id;

    @Column(name = "book_id", nullable = false)
    private int book_id;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Book book;


}
