package com.examly.springapp.service;

import com.examly.springapp.model.PurchaseOrderItem;
import java.util.List;

public interface PurchaseOrderItemService {
    PurchaseOrderItem savePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem);
    List<PurchaseOrderItem> getAllPurchaseOrderItems();
    PurchaseOrderItem getPurchaseOrderItemById(Long id);
    List<PurchaseOrderItem> getPurchaseOrderItemsByOrderId(Long orderId);
    PurchaseOrderItem updatePurchaseOrderItem(Long id, PurchaseOrderItem purchaseOrderItem);
    void deletePurchaseOrderItem(Long id);
}