package com.threadseven.javaexamples.assertinglists;

import java.util.List;

public record Order(String id, List<LineItem> lineItems) {
}
