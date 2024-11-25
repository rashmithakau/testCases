package com.demo.Demo.service;

import com.demo.Demo.dto.CustomerDTO;
import com.demo.Demo.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerUpdateDTO customerUpdateDTO);
    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomersByActiveState(boolean state);
}
