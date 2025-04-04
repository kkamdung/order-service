package com.polarbookshop.orderservice.order.event;

public record OrderDispatchedMessage(
    long orderId
) {
}
