package com.dynamicpricing.api.exception;

import java.util.UUID;

public class VendorNotFoundException extends RuntimeException{

    public VendorNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
    }

    public VendorNotFoundException(String s) {}

    public VendorNotFoundException(UUID id) {}
}
