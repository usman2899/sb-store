package com.example.store.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class CreateProductRequest {
    @JsonAlias("name")
    protected String name;

    @JsonAlias("quantity")
    protected BigDecimal quantity;
}
