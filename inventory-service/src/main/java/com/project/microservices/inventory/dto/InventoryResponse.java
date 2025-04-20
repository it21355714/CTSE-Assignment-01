package com.project.microservices.inventory.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {
    private String id;
    private String name;
    private int quantity;
    private BigDecimal price;
    private LocalDateTime created_at;
}
