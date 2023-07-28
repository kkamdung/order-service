package com.polarbookshop.orderservice.order.domain;

import com.polarbookshop.orderservice.book.Book;
import com.polarbookshop.orderservice.book.BookClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookClient bookClient;

    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Mono<Order> submitOrder(String isbn, int quantity) {
        return bookClient.getBookByIsbn(isbn)
                .map(book -> acceptOrder(book, quantity))
                .defaultIfEmpty(rejectOrder(isbn, quantity))
                .flatMap(orderRepository::save);
    }

    private Order acceptOrder(Book book, int quantity) {
        return Order.builder()
                .bookIsbn(book.getIsbn())
                .bookName(book.getTitle() + " - " + book.getAuthor())
                .bookPrice(book.getPrice())
                .quantity(quantity)
                .status(OrderStatus.ACCEPTED)
                .build();
    }

    private Order rejectOrder(String isbn, int quantity) {
        return Order.builder()
                .bookIsbn(isbn)
                .quantity(quantity)
                .status(OrderStatus.REJECTED)
                .build();
    }

}
