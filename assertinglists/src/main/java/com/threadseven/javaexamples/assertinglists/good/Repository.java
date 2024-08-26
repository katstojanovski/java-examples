package com.threadseven.javaexamples.assertinglists.good;

import java.util.List;

import com.threadseven.javaexamples.assertinglists.Database;
import com.threadseven.javaexamples.assertinglists.LineItem;
import com.threadseven.javaexamples.assertinglists.Order;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Repository {

    private final Database database;
    
    public List<LineItem> getLineItemsByOrderId(String id) {
        final Order order = database.getById(id);
        return order.lineItems();
    }
}
