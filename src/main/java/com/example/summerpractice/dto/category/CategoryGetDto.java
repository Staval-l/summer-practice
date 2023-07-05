package com.example.summerpractice.dto.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CategoryGetDto {
    private final Long id;
    private final String name;
}
