package com.example.summerpractice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResponseGetDto<T> {
    private final Integer code;
    private final String description;
    private final T payload;

    public static <T> ResponseGetDto<T> ok(T result) {
        return new ResponseGetDto<>(0, null, result);
    }
}
