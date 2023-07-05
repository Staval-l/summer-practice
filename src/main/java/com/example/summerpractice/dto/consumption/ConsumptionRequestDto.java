package com.example.summerpractice.dto.consumption;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class ConsumptionRequestDto {
    @NotNull(message = "Enter period's start")
    private final LocalDate dateFrom;

    @NotNull(message = "Enter period's end")
    private final LocalDate dateTo;
}
