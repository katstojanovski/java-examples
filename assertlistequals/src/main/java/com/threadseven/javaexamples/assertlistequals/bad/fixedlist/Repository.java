package com.threadseven.javaexamples.assertlistequals.bad.fixedlist;

import java.util.List;

import com.threadseven.javaexamples.assertlistequals.Database;
import com.threadseven.javaexamples.assertlistequals.Order;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Repository {

    private final Database database;

    public List<Order> getOrders() {
        final var orders = database.getOrders();
        orders.set(0, new Order("9999999999"));
        return orders;
    }
}
