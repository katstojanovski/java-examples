package com.threadseven.javaexamples.unittesting.mutableclass.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private String id;
    private String customerId;
} 
