package com.project.microservices.inventory.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {
    private int id;
    private String name;
    private int quantity;
    private BigDecimal price;
    private Timestamp created_at;
}
