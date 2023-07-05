package com.example.summerpractice.controller;

import com.example.summerpractice.dto.ResponseGetDto;
import com.example.summerpractice.dto.consumption.ConsumptionGetDto;
import com.example.summerpractice.dto.consumption.ConsumptionPostDto;
import com.example.summerpractice.dto.consumption.ConsumptionRequestDto;
import com.example.summerpractice.dto.consumption.ConsumptionResponseDto;
import com.example.summerpractice.mapper.ConsumptionMapper;
import com.example.summerpractice.service.ConsumptionService;
import com.example.summerpractice.util.ResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consumption")
@Validated
@RequiredArgsConstructor
public class ConsumptionController {
    private final ConsumptionService debitService;
    private final ConsumptionMapper debitMapper;

    @PutMapping
    public ResponseGetDto<ConsumptionGetDto> createDebit(@RequestBody ConsumptionPostDto request) {
        return ResponseFactory.createSuccessfulResponse(debitMapper.toDto(debitService.createConsumption(
                request.getCategoryId(), request.getValue(), request.getDebitTime(), request.getDescription())));
    }

    @PostMapping("/statistic")
    public ResponseGetDto<ConsumptionResponseDto> generateStatistic(@RequestBody ConsumptionRequestDto request) {
        List<ConsumptionGetDto> debits = debitService.getAllForPeriod(request.getDateFrom(), request.getDateTo()).stream()
                .map(debitMapper::toDto)
                .collect(Collectors.toList());
        return ResponseFactory.createSuccessfulResponse(new ConsumptionResponseDto(
                debits,
                debits.stream().map(ConsumptionGetDto::getValue).reduce(0D, Double::sum)));
    }
}
