package com.dynamicpricing.api.service;

import com.dynamicpricing.api.exception.VendorNotFoundException;
import com.dynamicpricing.api.model.Vendor;
import com.dynamicpricing.api.repo.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public Vendor getVendorById(UUID id) {
        return vendorRepository.findById(id)
                .orElseThrow(() -> new VendorNotFoundException(id));
    }

    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Vendor updateVendor(UUID id, Vendor updatedVendor) {
        Vendor existingVendor = vendorRepository.findById(id)
                .orElseThrow(() -> new VendorNotFoundException(id));

        existingVendor.setName(updatedVendor.getName());
        existingVendor.setEmail(updatedVendor.getEmail());
        existingVendor.setPhone(updatedVendor.getPhone());
        existingVendor.setWebsite(updatedVendor.getWebsite());

        return vendorRepository.save(existingVendor);
    }

    public void deleteVendor(UUID id) {
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new VendorNotFoundException(id));

        vendorRepository.delete(vendor);
    }
}
