package com.examly.springapp.service;

import com.examly.springapp.model.PurchaseOrder;
import java.util.List;

public interface PurchaseOrderService {
    PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder);
    List<PurchaseOrder> getAllPurchaseOrders();
    PurchaseOrder getPurchaseOrderById(Long id);
    PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder purchaseOrder);
    void deletePurchaseOrder(Long id);
}