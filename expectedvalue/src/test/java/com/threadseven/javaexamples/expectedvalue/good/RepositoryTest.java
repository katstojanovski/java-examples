package com.threadseven.javaexamples.expectedvalue.good;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    void shouldSuccessfullyReturnOrderFromDatabase() {
        final var orderId = "1234567890";
        final var customerId = "someCustomer";
        final var order = new Order(orderId, customerId);
        when(database.getOrderById(orderId)).thenReturn(order);

        final var actual = repository.getOrderById(orderId);

        final var expected = new Order(orderId, customerId);
        assertEquals(expected, actual);
    }
}
