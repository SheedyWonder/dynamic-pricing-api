package com.dynamicpricing.api.repo;

import com.dynamicpricing.api.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VendorRepository extends JpaRepository<Vendor, UUID> {}
