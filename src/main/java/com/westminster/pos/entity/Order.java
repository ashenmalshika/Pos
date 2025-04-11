package com.westminster.pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    @Id
    @Column(name = "order_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date orderDate;

    @Column(name = "total", nullable = false)
    private Double total;

    @OneToMany(mappedBy = "orders")
    private Set<OrderDetails> orderDetails;

    public Order(Customer customer, Double total, Date orderDate) {
        this.customer = customer;
        this.total = total;
        this.orderDate = orderDate;
    }
//    @ManyToOne
//    @JoinColumn(name = "order_id",nullable = false)
//    private Order orders;


}
