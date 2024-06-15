package com.threadseven.javaexamples.unittesting.mutableclass.bad;

import com.threadseven.javaexamples.unittesting.mutableclass.Database;

public class OrderRepository {

    public OrderRepository(final Database database) {
        this.database = database;
    }

    private final Database database;

    public void save(final Order order) {
        order.setCustomerId("someOtherCustomer");
        database.save(order);
    }
}
