package com.examly.springapp.controller;

import com.examly.springapp.model.CustomerReturn;
import com.examly.springapp.service.CustomerReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customer-returns")
public class CustomerReturnController {
    
    @Autowired
    private CustomerReturnService customerReturnService;
    
    @PostMapping
    public ResponseEntity<CustomerReturn> createCustomerReturn(@RequestBody CustomerReturn customerReturn) {
        CustomerReturn savedReturn = customerReturnService.saveCustomerReturn(customerReturn);
        return new ResponseEntity<>(savedReturn, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<CustomerReturn>> getAllCustomerReturns() {
        List<CustomerReturn> returns = customerReturnService.getAllCustomerReturns();
        if (returns.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(returns, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CustomerReturn> getCustomerReturnById(@PathVariable Long id) {
        CustomerReturn customerReturn = customerReturnService.getCustomerReturnById(id);
        if (customerReturn != null) {
            return new ResponseEntity<>(customerReturn, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CustomerReturn> updateCustomerReturn(@PathVariable Long id, @RequestBody CustomerReturn customerReturn) {
        CustomerReturn updatedReturn = customerReturnService.updateCustomerReturn(id, customerReturn);
        if (updatedReturn != null) {
            return new ResponseEntity<>(updatedReturn, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerReturn(@PathVariable Long id) {
        customerReturnService.deleteCustomerReturn(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
