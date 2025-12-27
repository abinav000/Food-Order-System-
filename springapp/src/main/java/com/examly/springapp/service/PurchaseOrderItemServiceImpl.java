package com.examly.springapp.service;

import com.examly.springapp.model.PurchaseOrderItem;
import com.examly.springapp.repository.PurchaseOrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseOrderItemServiceImpl implements PurchaseOrderItemService {
    
    @Autowired
    private PurchaseOrderItemRepo purchaseOrderItemRepo;
    
    @Override
    public PurchaseOrderItem savePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) {
        return purchaseOrderItemRepo.save(purchaseOrderItem);
    }
    
    @Override
    public List<PurchaseOrderItem> getAllPurchaseOrderItems() {
        return purchaseOrderItemRepo.findAll();
    }
    
    @Override
    public PurchaseOrderItem getPurchaseOrderItemById(Long id) {
        return purchaseOrderItemRepo.findById(id).orElse(null);
    }
    
    @Override
    public List<PurchaseOrderItem> getPurchaseOrderItemsByOrderId(Long orderId) {
        return purchaseOrderItemRepo.findByPurchaseOrderPurchaseOrderId(orderId);
    }
    
    @Override
    public PurchaseOrderItem updatePurchaseOrderItem(Long id, PurchaseOrderItem purchaseOrderItem) {
        if (purchaseOrderItemRepo.existsById(id)) {
            purchaseOrderItem.setPurchaseOrderItemId(id);
            return purchaseOrderItemRepo.save(purchaseOrderItem);
        }
        return null;
    }
    
    @Override
    public void deletePurchaseOrderItem(Long id) {
        purchaseOrderItemRepo.deleteById(id);
    }
}