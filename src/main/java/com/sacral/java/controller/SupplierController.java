package com.sacral.java.controller;

import com.sacral.java.model.Supplier;
import com.sacral.java.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<Supplier> getSupplierByUsername(@PathVariable String username) {
        Supplier supplier = supplierService.findByUsername(username);
        if (supplier != null) {
            return new ResponseEntity<>(supplier, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Supplier> login(@RequestParam String username, @RequestParam String password) {
        Supplier supplier = supplierService.findByUsernameAndPassword(username, password);
        if (supplier != null) {
            return new ResponseEntity<>(supplier, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    // Other business methods can be added here

}