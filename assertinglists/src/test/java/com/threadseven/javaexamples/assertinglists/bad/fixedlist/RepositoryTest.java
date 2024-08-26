package com.threadseven.javaexamples.assertinglists.bad.fixedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

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
    void shouldReturnListOfSizeOne() {
        final var orderId = "1234567890";
        final var lineItemSku = "someSku";
        final var lineItem = new LineItem(1, lineItemSku);
        // mutable, but fixed size
        final var order = new Order(orderId, Arrays.asList(lineItem));
        when(database.getById(orderId)).thenReturn(order);

        final var actual = repository.getLineItemsByOrderId(orderId);

        assertEquals(1, actual.size());
        assertEquals(lineItemSku, actual.get(0).sku());
    }

    @Test
    void shouldSuccessfullyReturnLineItems() {
        final var orderId = "1234567890";
        final var lineItem = new LineItem(1, "someSku");
        final var order = new Order(orderId, Arrays.asList(lineItem));
        when(database.getById(orderId)).thenReturn(order);

        final var actual = repository.getLineItemsByOrderId(orderId);

        assertEquals(order.lineItems(), actual);
    }

}
