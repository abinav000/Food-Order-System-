package com.examly.springapp.service;

import com.examly.springapp.model.PurchaseOrder;
import com.examly.springapp.repository.PurchaseOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    
    @Autowired
    private PurchaseOrderRepo purchaseOrderRepo;
    
    @Override
    public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepo.save(purchaseOrder);
    }
    
    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepo.findAll();
    }
    
    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
        return purchaseOrderRepo.findById(id).orElse(null);
    }
    
    @Override
    public PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder purchaseOrder) {
        if (purchaseOrderRepo.existsById(id)) {
            purchaseOrder.setPurchaseOrderId(id);
            return purchaseOrderRepo.save(purchaseOrder);
        }
        return null;
    }
    
    @Override
    public void deletePurchaseOrder(Long id) {
        purchaseOrderRepo.deleteById(id);
    }
}