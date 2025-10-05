package com.infinity.springrestapi.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class StoreProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private Byte categoryId;
}
