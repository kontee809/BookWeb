package com.book.bookapplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "payment_status", nullable = false)
    private int paymentStatus;

    @Column(name = "amount_total", nullable = false)
    private double amountTotal;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "user_id", nullable = false)
    private int user_id;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
