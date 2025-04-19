package com.project.microservices.inventory.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryRequest {
    private String name;
    @Min(value = 0, message = "Quantity can not be negative")
    @NotNull
    private int quantity;
    private BigDecimal price;
}
