package com.example.summerpractice.dto.consumption;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ConsumptionResponseDto {
    private final List<ConsumptionGetDto> debits;
    private final Double debitSummary;
}
