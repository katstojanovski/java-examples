package com.threadseven.javaexamples.assertinglists.bad.mutablelist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.threadseven.javaexamples.assertinglists.Database;
import com.threadseven.javaexamples.assertinglists.LineItem;
import com.threadseven.javaexamples.assertinglists.Order;

@ExtendWith(MockitoExtension.class)
class RepositoryTest {

    private Repository repository;

    @Mock
    private Database database;

    @BeforeEach
    void init() {
        repository = new Repository(database);
    }

    @Test
    void shouldReturnLineItemWithNumberAndSku() {
        final var orderId = "1234567890";
        final var lineItemNumber = 1;
        final var lineItemSku = "someSku";
        final var lineItem = new LineItem(lineItemNumber, lineItemSku);
        // mutable and not fixed size
        final var order = new Order(orderId, new ArrayList<LineItem>() {
            {
                add(lineItem);
            }
        });
        when(database.getById(orderId)).thenReturn(order);

        final var actual = repository.getLineItemsByOrderId(orderId);

        assertEquals(lineItemNumber, actual.get(0).number());
        assertEquals(lineItemSku, actual.get(0).sku());
    }

    @Test
    void shouldSuccessfullyReturnLineItems() {
        final var orderId = "1234567890";
        final var lineItem = new LineItem(1, "someSku");
        final var order = new Order(orderId, new ArrayList<LineItem>() {
            {
                add(lineItem);
            }
        });
        when(database.getById(orderId)).thenReturn(order);

        final var actual = repository.getLineItemsByOrderId(orderId);

        assertEquals(order.lineItems(), actual);
    }
}
