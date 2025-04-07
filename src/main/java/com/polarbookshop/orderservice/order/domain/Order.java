package com.polarbookshop.orderservice.order.domain;

import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("orders")
public record Order(
    @Id
    Long id,

    String bookIsbn,
    String bookName,
    Double bookPrice,
    Integer quantity,
    OrderStatus status,

    @CreatedBy
    String createdBy,

    @CreatedDate
    Instant createdDate,

    @LastModifiedBy
    String lastModifiedBy,

    @LastModifiedDate
    Instant lastModifiedDate,

    @Version
    int version
) {

    public static Order of(String bookIsbn, String bookName, Double bookPrice, Integer quantity, OrderStatus status) {
        return new Order(null, bookIsbn, bookName, bookPrice, quantity, status, null, null, null, null, 0);
    }

}
