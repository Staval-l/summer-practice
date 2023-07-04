package com.example.summerpractice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "category")
@NoArgsConstructor
@Setter
@Getter
public class Category {
    @Id
    private long id;
    @Column
    private String name;
}
