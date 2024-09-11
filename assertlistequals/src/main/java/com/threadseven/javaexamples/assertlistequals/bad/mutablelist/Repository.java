package com.threadseven.javaexamples.assertlistequals.bad.mutablelist;

import java.util.List;

import com.threadseven.javaexamples.assertlistequals.Database;
import com.threadseven.javaexamples.assertlistequals.Order;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Repository {

    private final Database database;

    public List<Order> getOrders() {
        final var orders = database.getOrders();
        orders.add(new Order("9999999999"));
        return orders;
    }
}
