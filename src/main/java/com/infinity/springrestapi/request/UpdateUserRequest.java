package com.infinity.springrestapi.request;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String name;
    private String email;
}
