package com.threadseven.javaexamples.unittesting.mutableclass.repository;

import com.threadseven.javaexamples.unittesting.mutableclass.domain.Order;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class OrderRepository {

    private final Database database;

    public void save(final Order order) {
        order.setCustomerId("someOtherCustomer");
        database.save(order);
    }

}
