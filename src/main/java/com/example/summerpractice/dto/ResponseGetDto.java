package com.example.summerpractice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
public class ResponseGetDto<T> {
    private final String code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String description;
    private final T payload;

    public static <T> ResponseGetDto<T> ok(T result) {
        return new ResponseGetDto<>("ok", null, result);
    }

    public static <T> ResponseGetDto<T> badRequest(String description) {
        return new ResponseGetDto<>("bad_request", description, null);
    }
}
