package com.examly.springapp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CustomerReturn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerReturnId;
    private LocalDateTime returnDate;
    private Integer quantity;
    private String reason;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public CustomerReturn() {}

    public Long getCustomerReturnId() { return customerReturnId; }
    public void setCustomerReturnId(Long customerReturnId) { this.customerReturnId = customerReturnId; }
    public LocalDateTime getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDateTime returnDate) { this.returnDate = returnDate; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}

