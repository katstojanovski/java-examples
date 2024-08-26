package com.threadseven.javaexamples.expectedresult.bad;

import com.threadseven.javaexamples.expectedresult.Database;

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
