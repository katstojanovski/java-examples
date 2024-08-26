package com.threadseven.javaexamples.expectedvalue.bad;

import com.threadseven.javaexamples.expectedvalue.Database;

public class Repository {

    public Repository(final Database database) {
        this.database = database;
    }

    private final Database database;

    public void save(final Order order) {
        order.setCustomerId("someOtherCustomer");
        database.save(order);
    }
}
