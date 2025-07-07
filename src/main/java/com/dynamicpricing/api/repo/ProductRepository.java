package com.dynamicpricing.api.repo;

import com.dynamicpricing.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {}
