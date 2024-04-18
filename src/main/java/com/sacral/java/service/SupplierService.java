package com.sacral.java.service;

import com.sacral.java.model.Supplier;
import com.sacral.java.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier findByUsername(String username) {
        return supplierRepository.findByUsername(username);
    }

    public Supplier findByUsernameAndPassword(String username, String password) {
        return supplierRepository.findByUsernameAndPassword(username, password);
    }

    // Other business methods can be added here

}