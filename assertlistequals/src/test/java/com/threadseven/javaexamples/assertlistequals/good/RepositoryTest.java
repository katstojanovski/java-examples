package com.threadseven.javaexamples.assertlistequals.good;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.threadseven.javaexamples.assertlistequals.Database;
import com.threadseven.javaexamples.assertlistequals.LineItem;
import com.threadseven.javaexamples.assertlistequals.Order;

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
    void successfullyReturnLineItems() {
        final var orderId = "1234567890";
        final var lineItemNumber = 1;
        final var lineItemSku = "someSku";
        final var lineItem = new LineItem(lineItemNumber, lineItemSku);
        final var order = new Order(orderId, List.of(lineItem));
        when(database.getById(orderId)).thenReturn(order);

        final var expected = List.of(new LineItem(lineItemNumber, lineItemSku));

        final var actual = repository.getLineItemsByOrderId(orderId);

        assertEquals(expected, actual);
    }    
}
