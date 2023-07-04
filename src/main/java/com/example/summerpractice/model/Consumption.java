package com.example.summerpractice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "consumption")
@NoArgsConstructor
@Setter
@Getter
public class Consumption {
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;
    @Column
    private double value;
    @Column
    private LocalDateTime createTime;
    @Column
    private String description;
}
