package com.infinity.springrestapi.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PageMetadata {
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
}
