package com.threadseven.javaexamples.expectedvalue.good;

import com.threadseven.javaexamples.expectedvalue.Database;

public class OrderRepository {

    public OrderRepository(final Database database) {
        this.database = database;
    }

    private final Database database;

    public void save(final Order order) {
        database.save(order);
    }

}
