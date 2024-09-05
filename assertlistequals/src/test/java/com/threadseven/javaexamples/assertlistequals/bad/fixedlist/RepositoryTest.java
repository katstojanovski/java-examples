package com.threadseven.javaexamples.assertlistequals.bad.fixedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

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

    private static final String LINE_ITEM_SKU = "someSku";
    private static final String ORDER_ID = "1234567890";

    private Repository repository;

    @Mock
    private Database database;

    @BeforeEach
    void init() {
        repository = new Repository(database);
    }

    @Test
    void shouldReturnListOfSizeOne() {
        final var lineItem = new LineItem(1, LINE_ITEM_SKU);
        // mutable, but fixed size
        final var order = new Order(ORDER_ID, Arrays.asList(lineItem));
        when(database.getById(ORDER_ID)).thenReturn(order);

        final var actual = repository.getLineItemsByOrderId(ORDER_ID);

        assertEquals(1, actual.size());
    }

    @Test
    void shouldSuccessfullyReturnLineItems() {
        final var lineItem = new LineItem(1, LINE_ITEM_SKU);
        final var order = new Order(ORDER_ID, Arrays.asList(lineItem));
        when(database.getById(ORDER_ID)).thenReturn(order);

        final var actual = repository.getLineItemsByOrderId(ORDER_ID);

        assertEquals(order.lineItems(), actual);
    }

}
