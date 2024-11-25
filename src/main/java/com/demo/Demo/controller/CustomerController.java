package com.demo.Demo.controller;

import com.demo.Demo.dto.CustomerDTO;
import com.demo.Demo.dto.request.CustomerUpdateDTO;
import com.demo.Demo.entiry.CustomerEntity;
import com.demo.Demo.repositary.CustomerRepositary;
import com.demo.Demo.service.ItemService;
import com.demo.Demo.service.impl.CustomerServiceImpl;
import com.demo.Demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private CustomerRepositary customerRepositary;
    @Autowired
    private CustomerServiceImpl customerServiceImpl;


    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
        System.out.println(customerDTO);
        customerService.saveCustomer(customerDTO);
        return "success";
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        customerService.updateCustomer(customerUpdateDTO);
    }

    @GetMapping(path = "/get-by-id", params = "id") //search using request params
    public CustomerDTO GetCustomerById(@RequestParam(value = "id") int customerId) {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping("get-all-customers")
    public ResponseEntity<StandardResponse> getAllCustomers() {
        StandardResponse response = new StandardResponse(200, "Success", customerService.getAllCustomers());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerId) {
        String msg = customerServiceImpl.deleteCustomer(customerId);
        return msg;
    }

    @GetMapping(path = "/get-all-customers-by-active-state/", params = "state")
    public List<CustomerDTO> getAllCustomersByActiveState(@RequestParam(value = "state") boolean state) {
        return customerService.getAllCustomersByActiveState(state);
    }
}
