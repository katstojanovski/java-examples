package com.threadseven.javaexamples.assertlistequals.bad.mutablelist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
    private static final int LINE_ITEM_NUMBER = 1;

    private Repository repository;

    @Mock
    private Database database;

    @BeforeEach
    void init() {
        repository = new Repository(database);
    }

    @Test
    void shouldReturnLineItemWithNumberAndSku() {
        final var lineItem = new LineItem(LINE_ITEM_NUMBER, LINE_ITEM_SKU);
        // mutable and resizable
        final var order = new Order(ORDER_ID, new ArrayList<LineItem>() {
            {
                add(lineItem);
            }
        });
        when(database.getById(ORDER_ID)).thenReturn(order);

        final var actual = repository.getLineItemsByOrderId(ORDER_ID);

        assertEquals(LINE_ITEM_NUMBER, actual.get(0).number());
        assertEquals(LINE_ITEM_SKU, actual.get(0).sku());
    }

    @Test
    void shouldSuccessfullyReturnLineItems() {
        final var lineItem = new LineItem(1, LINE_ITEM_SKU);
        final var order = new Order(ORDER_ID, new ArrayList<LineItem>() {
            {
                add(lineItem);
            }
        });
        when(database.getById(ORDER_ID)).thenReturn(order);

        final var actual = repository.getLineItemsByOrderId(ORDER_ID);

        assertEquals(order.lineItems(), actual);
    }
}
