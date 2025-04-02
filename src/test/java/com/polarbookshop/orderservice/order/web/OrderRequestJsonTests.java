package com.polarbookshop.orderservice.order.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class OrderRequestJsonTests {

    @Autowired
    private JacksonTester<OrderRequest> json;

    @Test
    void testDeserialize() throws IOException {
        String content = """
                {
                    "isbn": "1234567890",
                    "quantity": 1
                }
                """;

        assertThat(json.parse(content))
                .usingRecursiveComparison().isEqualTo(new OrderRequest("1234567890", 1));

    }

}
