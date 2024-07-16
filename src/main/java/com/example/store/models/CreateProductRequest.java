package com.example.store.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateProductRequest {
  @JsonAlias("name")
  protected String name;

  @JsonAlias("quantity")
  protected BigDecimal quantity;
}
