package com.threadseven.javaexamples.assertlistequals;

import java.util.List;

public record Order(String id, List<LineItem> lineItems) {
}
