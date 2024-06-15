package com.threadseven.javaexamples.unittesting.mutableclass.bad;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.threadseven.javaexamples.unittesting.mutableclass.Database;

@ExtendWith(MockitoExtension.class)
class OrderRepositoryTest {

    private OrderRepository orderRepository;

    @Mock
    private Database database;

    @BeforeEach
    void init() {
        orderRepository = new OrderRepository(database);
    }

    @Test
    void shouldSuccessfullySaveOrderToDatabase() {
        final var order = new Order("1234567890", "someCustomer");
        orderRepository.save(order);
        verify(database, times(1)).save(order);
    }
}
