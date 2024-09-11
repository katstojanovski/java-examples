package com.threadseven.javaexamples.expectedvalue.bad;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Repository {

    private final Database database;

    public Order getOrderById(final String orderId) {
        final var order = database.getOrderById(orderId);
        order.setCustomerId("someOtherCustomer");
        return order;
    }
}
