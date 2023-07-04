package com.example.summerpractice.repository;

import com.example.summerpractice.model.Consumption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsumptionRepository extends CrudRepository<Consumption, Long> {
    List<Consumption> findAllByConsumptionTimeBetweenOrderByConsumptionTime(LocalDate dateFrom, LocalDate dateTo);
}
