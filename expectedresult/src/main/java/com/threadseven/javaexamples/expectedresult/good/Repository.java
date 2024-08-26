package com.threadseven.javaexamples.expectedresult.good;

import com.threadseven.javaexamples.expectedresult.Database;

public class Repository {

    public Repository(final Database database) {
        this.database = database;
    }

    private final Database database;

    public void save(final Order order) {
        database.save(order);
    }

}
