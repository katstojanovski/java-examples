package com.threadseven.javaexamples.expectedvalue.good;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class Repository {

    private final Database database;

    public Order getOrderById(final String orderId) {
        return database.getOrderById(orderId);
    }
}
