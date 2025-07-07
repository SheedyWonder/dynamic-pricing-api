package com.dynamicpricing.api.exception;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
    }

    public ProductNotFoundException(String s) {}

    public ProductNotFoundException(UUID id) {}
}
