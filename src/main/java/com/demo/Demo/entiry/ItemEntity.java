package com.demo.Demo.entiry;

import com.demo.Demo.entiry.enums.MeasuringUnitPirce;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    @Column(name = "item_id",length = 32)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name="item_name",length = 32)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type",length = 100,nullable = false)
    private MeasuringUnitPirce measuringUnitPrice;

    @Column(name = "balance_qty",nullable = false)
    private Double balanceQty;

    @Column(name = "supplier_price",nullable = false)
    private double supplierPrice;

    @Column(name="selling_price",nullable = false)
    private double sellingPrice;

    @Column(name="active_state")
    private boolean activeState;

}
