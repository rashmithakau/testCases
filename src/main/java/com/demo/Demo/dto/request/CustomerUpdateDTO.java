package com.demo.Demo.dto.request;

import lombok.Data;

@Data
public class CustomerUpdateDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
}
