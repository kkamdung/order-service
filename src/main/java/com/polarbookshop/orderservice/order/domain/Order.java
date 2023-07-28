package com.polarbookshop.orderservice.order.domain;

import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Builder
@Table("orders")
public class Order {

    @Id
    private Long id;

    private String bookIsbn;
    private String bookName;
    private Double bookPrice;
    private Integer quantity;
    private OrderStatus status;

    @CreatedDate
    private Instant createDate;

    @LastModifiedDate
    private Instant lastModifiedDate;

    @Version
    private int version;

}
