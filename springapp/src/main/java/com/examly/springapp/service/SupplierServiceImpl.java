package com.examly.springapp.service;

import com.examly.springapp.model.Supplier;
import com.examly.springapp.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    
    @Autowired
    private SupplierRepo supplierRepo;
    
    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }
    
    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }
    
    @Override
    public Supplier getSupplierById(Long id) {
        return supplierRepo.findById(id).orElse(null);
    }
    
    @Override
    public Supplier updateSupplier(Long id, Supplier supplier) {
        if (supplierRepo.existsById(id)) {
            supplier.setSupplierId(id);
            return supplierRepo.save(supplier);
        }
        return null;
    }
    
    @Override
    public void deleteSupplier(Long id) {
        supplierRepo.deleteById(id);
    }
}