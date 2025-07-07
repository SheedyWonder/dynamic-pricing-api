package com.dynamicpricing.api.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendors")
public class Vendor {
    @Id
    private UUID vendorId;
    private String name;

    public UUID getVendorId() {
        return vendorId;
    }

    public String getName() {
        return name;
    }

}
