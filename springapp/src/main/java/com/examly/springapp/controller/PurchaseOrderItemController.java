package com.examly.springapp.controller;

import com.examly.springapp.model.PurchaseOrderItem;
import com.examly.springapp.service.PurchaseOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/purchase-order-items")
public class PurchaseOrderItemController {
    
    @Autowired
    private PurchaseOrderItemService purchaseOrderItemService;
    
    @PostMapping
    public ResponseEntity<PurchaseOrderItem> createPurchaseOrderItem(@RequestBody PurchaseOrderItem purchaseOrderItem) {
        PurchaseOrderItem savedItem = purchaseOrderItemService.savePurchaseOrderItem(purchaseOrderItem);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<PurchaseOrderItem>> getAllPurchaseOrderItems() {
        List<PurchaseOrderItem> items = purchaseOrderItemService.getAllPurchaseOrderItems();
        if (items.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    
    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<PurchaseOrderItem>> getPurchaseOrderItemsByOrderId(@PathVariable Long orderId) {
        List<PurchaseOrderItem> items = purchaseOrderItemService.getPurchaseOrderItemsByOrderId(orderId);
        if (items.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrderItem> getPurchaseOrderItemById(@PathVariable Long id) {
        PurchaseOrderItem item = purchaseOrderItemService.getPurchaseOrderItemById(id);
        if (item != null) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrderItem> updatePurchaseOrderItem(@PathVariable Long id, @RequestBody PurchaseOrderItem purchaseOrderItem) {
        PurchaseOrderItem updatedItem = purchaseOrderItemService.updatePurchaseOrderItem(id, purchaseOrderItem);
        if (updatedItem != null) {
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseOrderItem(@PathVariable Long id) {
        purchaseOrderItemService.deletePurchaseOrderItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
