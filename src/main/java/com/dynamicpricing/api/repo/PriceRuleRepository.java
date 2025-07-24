package com.dynamicpricing.api.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dynamicpricing.api.model.PriceRule;

@Repository
public interface PriceRuleRepository extends JpaRepository<PriceRule, UUID>{}
