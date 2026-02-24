package com.infinity.springrestapi.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;
    private Object meta;
}
