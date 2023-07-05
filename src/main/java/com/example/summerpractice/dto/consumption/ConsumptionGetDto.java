package com.example.summerpractice.dto.consumption;

import com.example.summerpractice.dto.category.CategoryGetDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ConsumptionGetDto {
    private final Long id;
    private final CategoryGetDto category;
    private final Double value;
    private final LocalDateTime debitTime;
    private final String description;
}
