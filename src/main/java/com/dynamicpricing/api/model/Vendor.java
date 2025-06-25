package com.dynamicpricing.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Vendor {
    @Id
    private UUID vendorId;
    private String name;

}
