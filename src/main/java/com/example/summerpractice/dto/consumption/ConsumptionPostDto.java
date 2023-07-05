package com.example.summerpractice.dto.consumption;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ConsumptionPostDto {
    @NotNull(message = "Необходимо указать категорию расхода")
    private final Integer categoryId;

    @NotNull(message = "Необходимо указать сумму расхода")
    @Positive(message = "Размер расхода должен быть больше 0")
    private final Double value;

    private final String description;

    private final LocalDateTime debitTime;
}
