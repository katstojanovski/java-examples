package com.threadseven.javaexamples.expectedvalue.good;

import com.threadseven.javaexamples.expectedvalue.Database;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class Repository {

    private final Database database;

    public void save(final Order order) {
        database.save(order);
    }
}
