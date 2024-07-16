package com.example.store.entities;

import com.example.store.models.CreateProductRequest;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  /** Name of product */
  @Column(name = "name")
  protected String name;

  /** Quantity of product */
  @Column(name = "quantity", precision = 19, scale = 2)
  @lombok.NonNull protected BigDecimal quantity;

  /** Timestamp product was created at */
  @Column(name = "created_at", nullable = false, updatable = false)
  protected LocalDateTime createdAt;

  /** Timestamp product was last updated at */
  @Column(name = "last_updated_at")
  protected LocalDateTime lastUpdatedAt;

  public Product(CreateProductRequest request) {
    this.name = request.getName();
    this.quantity = request.getQuantity();
    this.createdAt = LocalDateTime.now();
    this.lastUpdatedAt = createdAt;
  }
}
