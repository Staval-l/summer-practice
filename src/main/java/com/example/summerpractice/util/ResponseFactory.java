package com.example.summerpractice.util;

import com.example.summerpractice.dto.ResponseGetDto;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

@UtilityClass
public class ResponseFactory {
    public static <T> ResponseGetDto<T> createSuccessfulResponse(T payload) {
        return new ResponseGetDto<>("Ok", null, payload);
    }

    public static ResponseGetDto<Void> createFailedResponse(HttpStatus status, String description) {
        return new ResponseGetDto<>("Bad", description, null);
    }
}
