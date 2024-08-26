package com.threadseven.javaexamples.expectedvalue.good;

import com.threadseven.javaexamples.expectedvalue.Database;

public class Repository {

    public Repository(final Database database) {
        this.database = database;
    }

    private final Database database;

    public void save(final Order order) {
        database.save(order);
    }

}
