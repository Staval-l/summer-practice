package com.example.summerpractice;

import com.example.summerpractice.dto.ResponseGetDto;
import com.example.summerpractice.dto.consumption.ConsumptionGetDto;
import com.example.summerpractice.dto.consumption.ConsumptionPostDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import java.time.LocalDateTime;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SummerPracticeApplicationTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    void createConsumption() {
        var dto = restTemplate.exchange(
                "http://localhost:" + port + "/consumption",
                HttpMethod.POST,
                new HttpEntity<>(new ConsumptionPostDto(1, 19.0, "SDGS", LocalDateTime.now())),
                new ParameterizedTypeReference<ConsumptionGetDto>() {
                }).getBody();
        assert dto != null;

        assert dto.getDescription().equals("SDGS");
        assert dto.getValue().equals(19.0);
    }

}
