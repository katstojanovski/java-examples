package com.threadseven.javaexamples.assertlistequals.bad.mutablelist;

import java.util.List;

import com.threadseven.javaexamples.assertlistequals.Database;
import com.threadseven.javaexamples.assertlistequals.LineItem;
import com.threadseven.javaexamples.assertlistequals.Order;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Repository {

    private final Database database;

    public List<LineItem> getLineItemsByOrderId(final String id) {
        final Order order = database.getById(id);
        order.lineItems().add(new LineItem(999, "someOtherSku"));
        return order.lineItems();
    }
}
