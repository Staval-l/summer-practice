package com.example.summerpractice.service;

import com.example.summerpractice.model.Category;
import com.example.summerpractice.model.Consumption;
import com.example.summerpractice.repository.ConsumptionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsumptionService {
    private final ConsumptionRepository consumptionRepository;
    private final CategoryService categoryService;

    public Consumption createConsumption(Integer categoryId, Double value, LocalDateTime debitTime, String description) {
        Category category = categoryService.getById(categoryId).orElseThrow(() -> new EntityNotFoundException("category"));

        Consumption consumption = new Consumption();
        consumption.setCategory_id(category);
        consumption.setCreateTime(debitTime != null ? debitTime : LocalDateTime.now());
        consumption.setValue(value);
        consumption.setDescription(description);

        return consumptionRepository.save(consumption);
    }

    public List<Consumption> getAllForPeriod(LocalDate dateFrom, LocalDate dateTo) {
        return consumptionRepository.findAllByConsumptionTimeBetweenOrderByConsumptionTime(dateFrom, dateTo);
    }
}
