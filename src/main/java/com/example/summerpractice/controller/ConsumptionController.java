package com.example.summerpractice.controller;

import com.example.summerpractice.dto.ResponseGetDto;
import com.example.summerpractice.dto.consumption.ConsumptionGetDto;
import com.example.summerpractice.dto.consumption.ConsumptionPostDto;
import com.example.summerpractice.dto.consumption.ConsumptionRequestDto;
import com.example.summerpractice.dto.consumption.ConsumptionResponseDto;
import com.example.summerpractice.model.Category;
import com.example.summerpractice.model.Consumption;
import com.example.summerpractice.service.ConsumptionService;
import com.example.summerpractice.util.ResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consumption")
@Validated
@RequiredArgsConstructor
public class ConsumptionController {
    private final ConsumptionService debitService;
    //private final ConsumptionMapper debitMapper;

    @PutMapping
    public ResponseGetDto<Consumption> createConsumption(@RequestBody ConsumptionPostDto request) {
//        return ResponseFactory.createSuccessfulResponse(debitMapper.toDto(debitService.createConsumption(
//                request.getCategoryId(), request.getValue(), request.getDebitTime(), request.getDescription())));
        return ResponseFactory.createSuccessfulResponse(debitService.createConsumption(request.getCategoryId(), request.getValue(), request.getDebitTime(), request.getDescription()));
    }

    @PostMapping("/statistic")
    public ResponseGetDto<ConsumptionResponseDto> generateStatistic(@RequestBody ConsumptionRequestDto request) {
//        List<ConsumptionGetDto> debits = debitService.getAllForPeriod(request.getDateFrom(), request.getDateTo()).stream()
//                .map(debitMapper::toDto)
//                .collect(Collectors.toList());
        List<Consumption> debits = debitService.getAllForPeriod(request.getDateFrom(), request.getDateTo()).stream().collect(Collectors.toList());
//        return ResponseFactory.createSuccessfulResponse(new ConsumptionResponseDto(
//                debits,
//                debits.stream().map(Consumption::getValue).reduce(0D, Double::sum)));
        return ResponseFactory.createSuccessfulResponse((ConsumptionResponseDto) debits.stream().collect(Collectors.toList()));
    }

    @GetMapping("/getConsumption")
    public ResponseGetDto<List<Consumption>> getConsumption() {
//        var consumptions = debitService.getAll();
//        var consumptionGetDto = new ConsumptionGetDto(consumptions.getId(),
//                consumptions.getCategory_id(),
//                consumptions.getValue(),
//                consumptions.getCreateTime(),
//                consumptions.getDescription());
//        return ResponseGetDto.ok(consumptionGetDto);
        return ResponseFactory.createSuccessfulResponse(debitService.getAll().stream().collect(Collectors.toList()));
    }
}
