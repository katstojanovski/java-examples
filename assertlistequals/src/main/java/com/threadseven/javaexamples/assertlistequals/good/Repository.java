package com.threadseven.javaexamples.assertlistequals.good;

import java.util.List;

import com.threadseven.javaexamples.assertlistequals.Database;
import com.threadseven.javaexamples.assertlistequals.Order;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Repository {

    private final Database database;

    public List<Order> getOrders() {
        return database.getOrders();
    }
}
