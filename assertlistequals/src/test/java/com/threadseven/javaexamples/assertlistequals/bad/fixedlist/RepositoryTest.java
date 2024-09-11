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
    void shouldReturnListOfSizeOne() {
        final var order = new Order("1234567890");
        // mutable, but fixed size
        final var orders = Arrays.asList(order);
        when(database.getOrders()).thenReturn(orders);

        final var actual = repository.getOrders();

        assertEquals(1, actual.size());
    }

    @Test
    void shouldSuccessfullyReturnOrders() {
        final var order = new Order("1234567890");
        final var orders = Arrays.asList(order);
        when(database.getOrders()).thenReturn(Arrays.asList(order));

        final var actual = repository.getOrders();

        assertEquals(orders, actual);
    }

}
