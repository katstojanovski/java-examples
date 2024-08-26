package com.threadseven.javaexamples.expectedvalue.good;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.threadseven.javaexamples.expectedvalue.Database;

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
        final var order = new Order("1234567890", "someCustomer");
        final var expectedOrder = new Order("1234567890", "someCustomer");
        repository.save(order);
        verify(database, times(1)).save(expectedOrder);
    }
}
