package com.demo.Demo.service.impl;

import com.demo.Demo.dto.CustomerDTO;
import com.demo.Demo.dto.request.CustomerUpdateDTO;
import com.demo.Demo.entiry.CustomerEntity;
import com.demo.Demo.exception.NotFoundException;
import com.demo.Demo.repositary.CustomerRepositary;
import com.demo.Demo.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    CustomerRepositary customerRepositary;
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity =objectMapper.convertValue(customerDTO,CustomerEntity.class);
        customerRepositary.save(customerEntity);
    }

    @Override
    public void updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepositary.existsById(customerUpdateDTO.getCustomerId())){
            CustomerEntity customerEntity=customerRepositary.getCustomerEntityByCustomerId(customerUpdateDTO.getCustomerId());

            customerEntity.setCustomerName(customerUpdateDTO.getCustomerName());
            customerEntity.setCustomerAddress( customerUpdateDTO.getCustomerAddress());
            customerEntity.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepositary.save(customerEntity);

        }else {
            throw new RuntimeException("Not found");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if(customerRepositary.existsById(customerId)){
            CustomerEntity customerEntity=customerRepositary.getCustomerEntityByCustomerId(customerId);
            CustomerDTO customerDTO=objectMapper.convertValue(customerEntity,CustomerDTO.class);
            return customerDTO;
        }else {
            throw new RuntimeException("Not found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerEntity> customerEntities= customerRepositary.findAll();

        if(customerEntities.size()>0){
            List<CustomerDTO> customerDTOlist=new ArrayList<CustomerDTO>();
            for(CustomerEntity e:customerEntities){
                customerDTOlist.add(objectMapper.convertValue(e,CustomerDTO.class));
            }
            return customerDTOlist;
        }
        throw new NotFoundException("No Customer found");

    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepositary.existsById(customerId)){
            customerRepositary.deleteById(customerId);
            return "deleted successfully";
        }else{
            throw new RuntimeException("Not found");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean state) {
            List<CustomerEntity> customerEntityList=customerRepositary.findAllByActiveEquals(state);
            List<CustomerDTO> customerDTOList=new ArrayList<CustomerDTO>();

            for(CustomerEntity customerEntity:customerEntityList){
                customerDTOList.add(objectMapper.convertValue(customerEntity,CustomerDTO.class));
            }
            return customerDTOList;
    }


}
