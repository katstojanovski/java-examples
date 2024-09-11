package com.threadseven.javaexamples.expectedvalue.bad;

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
    void shouldSuccessfullySaveOrderToDatabase() {
        final var orderId = "1234567890";
        final var order = new Order(orderId, "someCustomer");
        when(database.getOrderById(orderId)).thenReturn(order);

        var actual = repository.getOrderById(orderId);

        assertEquals(order, actual);
        
    }
}
