package com.project.microservices.inventory.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_inventory")
@EntityListeners(AuditingEntityListener.class)
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

	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
	private Timestamp  created_at;
}
