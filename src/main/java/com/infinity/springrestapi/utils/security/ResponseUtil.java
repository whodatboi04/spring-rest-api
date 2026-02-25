package com.infinity.springrestapi.utils.security;

import com.infinity.springrestapi.dtos.response.ApiResponse;
import com.infinity.springrestapi.dtos.response.PageMetadata;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ResponseUtil {
    // SUCCESS STATUS RESPONSE
    public static <T> ApiResponse<T> success(String message, T data, Object metadata) {
        return new  ApiResponse<>(
            "Success",
                message,
                data,
                metadata
            );
    }

    public static <T> ApiResponse<List<T>> paginatedSuccess(
            String message,
            Page<T> page
    ) {

        PageMetadata metadata = new PageMetadata(
                page.getNumber() + 1,     // convert to 1-based index
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );

        return new ApiResponse<>(
                "success",
                message,
                page.getContent(),
                metadata
        );
    }

    // ERROR STATUS RESPONSE
    public static <T> ApiResponse<T> error(String message, T data, Object metadata) {
        return new  ApiResponse<>(
                "error",
                message,
                data,
                null
        );
    }
}
