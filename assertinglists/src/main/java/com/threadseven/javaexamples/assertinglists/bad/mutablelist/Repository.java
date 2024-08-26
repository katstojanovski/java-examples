package com.threadseven.javaexamples.assertinglists.bad.mutablelist;

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
        order.lineItems().add(new LineItem(999, "someSku"));
        return order.lineItems();
    }
}
