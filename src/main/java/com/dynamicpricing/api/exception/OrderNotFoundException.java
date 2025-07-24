package com.dynamicpricing.api.exception;

import java.util.UUID;

public class OrderNotFoundException extends  RuntimeException {

    public OrderNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue));
    }

    public OrderNotFoundException(String s) {}

    public OrderNotFoundException(UUID id) {}
}
