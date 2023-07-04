package com.example.summerpractice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "consumption")
public class Consumption {
    @Id
    private long id;
    private long category_id;
    private double value;
    private Date createTime;
    private String description;
}