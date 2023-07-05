package com.example.summerpractice.mapper;

import org.mapstruct.Mapper;
import com.example.summerpractice.model.Consumption;
import com.example.summerpractice.dto.consumption.ConsumptionGetDto;

@Mapper(config = MapConfig.class)
public interface ConsumptionMapper {
    ConsumptionGetDto toDto(Consumption consumption);
}
