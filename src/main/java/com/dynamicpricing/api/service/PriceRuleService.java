package com.dynamicpricing.api.service;

import com.dynamicpricing.api.exception.PriceRuleNotFoundException;
import com.dynamicpricing.api.model.PriceRule;
import com.dynamicpricing.api.repo.PriceRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PriceRuleService {

    @Autowired
    private PriceRuleRepository priceRuleRepository;

    public PriceRule getPriceRuleById(UUID id) {
        return priceRuleRepository.findById(id)
                .orElseThrow(() -> new PriceRuleNotFoundException(id));
    }

    public PriceRule createPriceRule(PriceRule priceRule) {
        return priceRuleRepository.save(priceRule);
    }

    public List<PriceRule> getAllPriceRules() {
        return priceRuleRepository.findAll();
    }

    public PriceRule updatePriceRule(UUID id, PriceRule updatedPriceRule) {
        PriceRule existingPriceRule = priceRuleRepository.findById(id)
                .orElseThrow(() -> new PriceRuleNotFoundException(id));

        existingPriceRule.setActive(updatedPriceRule.isActive());
        existingPriceRule.setStartTime(updatedPriceRule.getStartTime());
        existingPriceRule.setEndTime(updatedPriceRule.getEndTime());
        existingPriceRule.setPriority(updatedPriceRule.getPriority());
        existingPriceRule.setStrategyType(updatedPriceRule.getStrategyType());
        existingPriceRule.setProduct(updatedPriceRule.getProduct());
        existingPriceRule.setParameters(updatedPriceRule.getParameters());

        return priceRuleRepository.save(existingPriceRule);
    }

    public void deletePriceRule(UUID id) {
        PriceRule priceRule = priceRuleRepository.findById(id)
                .orElseThrow(() -> new PriceRuleNotFoundException(id));

        priceRuleRepository.delete(priceRule);
    }
}
