package com.demo.Demo.dto;

import com.demo.Demo.entiry.enums.MeasuringUnitPirce;
import lombok.Data;

@Data
public class ItemDTO {
    private int itemId;
    private String itemName;
    private MeasuringUnitPirce measuringUnitPrice;
    private Double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeState;
}
