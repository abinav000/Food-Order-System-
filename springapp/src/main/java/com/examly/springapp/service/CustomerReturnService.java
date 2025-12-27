package com.examly.springapp.service;

import com.examly.springapp.model.CustomerReturn;
import java.util.List;

public interface CustomerReturnService {
    CustomerReturn saveCustomerReturn(CustomerReturn customerReturn);
    List<CustomerReturn> getAllCustomerReturns();
    CustomerReturn getCustomerReturnById(Long id);
    CustomerReturn updateCustomerReturn(Long id, CustomerReturn customerReturn);
    void deleteCustomerReturn(Long id);
}