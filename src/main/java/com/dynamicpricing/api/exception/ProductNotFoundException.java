package com.dynamicpricing.api.exception;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ProductNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public ProductNotFoundException(String s) {}

    public ProductNotFoundException(UUID id) {}
}
