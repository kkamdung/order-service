package com.polarbookshop.orderservice.order.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Mono<Order> submitOrder(String isbn, int quantity) {
        return Mono.just(alwaysRejectOrder(isbn, quantity))
                .flatMap(orderRepository::save);
    }

    private Order alwaysRejectOrder(String isbn, int quantity) {
        return Order.builder()
                .bookIsbn(isbn)
                .quantity(quantity)
                .status(OrderStatus.REJECTED)
                .build();
    }

}
