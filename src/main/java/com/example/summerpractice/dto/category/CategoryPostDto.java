package com.example.summerpractice.dto.category;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CategoryPostDto {
    @NotBlank(message = "Name cannot be empty")
    private final String name;
}
