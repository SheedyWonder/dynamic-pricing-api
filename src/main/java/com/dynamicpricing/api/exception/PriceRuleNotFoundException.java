package com.dynamicpricing.api.exception;

import java.util.UUID;

public class PriceRuleNotFoundException extends RuntimeException {

    public PriceRuleNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
    }

    public PriceRuleNotFoundException(String s) {}

    public PriceRuleNotFoundException(UUID id) {}
}
