package com.project.microservices.inventory.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Inventory {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int Id;
	private String name;
	private int quantity;
	private BigDecimal  price;
	private Timestamp  created_at;
}
