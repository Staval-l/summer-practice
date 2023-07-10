package com.example.summerpractice.repository;

import com.example.summerpractice.model.Consumption;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsumptionRepository extends CrudRepository<Consumption, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM consumption")
    Consumption getConsumptions();
    List<Consumption> findAllByCreateTimeBetweenOrderByCreateTime(LocalDate dateFrom, LocalDate dateTo);
}
