package com.polarbookshop.orderservice.book;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Book {

    private String isbn;
    private String title;
    private String author;
    private Double price;

}
