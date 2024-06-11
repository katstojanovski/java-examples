package com.threadseven.javaexamples.unittesting.mutableclass.repository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.val;

import com.threadseven.javaexamples.unittesting.mutableclass.domain.Order;

@ExtendWith(MockitoExtension.class)
public class OrderRepositoryTest {

    private OrderRepository orderRepository;

    @Mock
    private Database database;

    @BeforeEach
    void init() {
        orderRepository = new OrderRepository(database);
    }

    @Test
    void falsePositive() {
        val order = Order.builder().id("1234567890").customerId("someCustomer").build();
        orderRepository.save(order);
        verify(database, times(1)).save(order);
    }

    @Test
    void trueNegative() {
        val order = Order.builder().id("1234567890").customerId("someCustomer").build();
        val expectedOrder = Order.builder().id("1234567890").customerId("someCustomer").build();
        orderRepository.save(order);
        verify(database, times(1)).save(expectedOrder);
    }
}
