package com.threadseven.javaexamples.assertlistequals.bad.mutablelist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.threadseven.javaexamples.assertlistequals.Database;
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
    void shouldReturnOrderWithId() {
        final var orderId = "1234567890";
        final var order = new Order(orderId);
        // mutable and resizable
        final var orders = new ArrayList<Order>() {
            {
                add(order);
            }
        };
        when(database.getOrders()).thenReturn(orders);

        final var actual = repository.getOrders();

        assertEquals(orderId, actual.get(0).id());
    }

    @Test
    void shouldSuccessfullyReturnOrders() {
        final var order = new Order("1234567890");
        // mutable and resizable
        final var orders = new ArrayList<Order>() {
            {
                add(order);
            }
        };
        when(database.getOrders()).thenReturn(orders);

        final var actual = repository.getOrders();

        assertEquals(orders, actual);
    }
}
