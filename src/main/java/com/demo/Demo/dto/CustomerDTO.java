package com.demo.Demo.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private String nic ;
    private boolean active;
}
