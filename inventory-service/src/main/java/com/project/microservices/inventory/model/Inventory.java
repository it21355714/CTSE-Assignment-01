package com.project.microservices.inventory.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.*;


@Data
@Document(collection = "inventory")
@AllArgsConstructor
@NoArgsConstructor

public class Inventory {
	@Id
	private String Id;
	private String name;
	private int quantity;
	private BigDecimal  price;

	@CreatedDate
	private LocalDateTime created_at;
}
