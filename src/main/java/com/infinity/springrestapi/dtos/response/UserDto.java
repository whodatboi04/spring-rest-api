package com.infinity.springrestapi.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class UserDto {

//    JSON ANNOTATION
//            - JsonInclude = to exclude null
//            - JsonProperty("name") = to change json name
//            - JsonIgnore = to ignore the data
//            -JsonFormat = to format date

    private Long id;
    private String name;
    private String email;
    @JsonFormat(pattern = "MMMM d,Y hh:mm a")
    private LocalDateTime createdAt;
}
