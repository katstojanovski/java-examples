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
    void successfullyReturnLineItems() {
        final var order = new Order(ORDER_ID, List.of(new LineItem(LINE_ITEM_NUMBER, LINE_ITEM_SKU)));
        when(database.getById(ORDER_ID)).thenReturn(order);
        final var expected = List.of(new LineItem(LINE_ITEM_NUMBER, LINE_ITEM_SKU));

        final var actual = repository.getLineItemsByOrderId(ORDER_ID);

        assertEquals(expected, actual);
    }    
}
