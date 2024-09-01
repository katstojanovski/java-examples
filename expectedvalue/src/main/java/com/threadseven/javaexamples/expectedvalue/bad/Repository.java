package com.threadseven.javaexamples.expectedvalue.bad;

import com.threadseven.javaexamples.expectedvalue.Database;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Repository {

    private final Database database;

    public void save(final Order order) {
        order.setCustomerId("someOtherCustomer");
        database.save(order);
    }
}
