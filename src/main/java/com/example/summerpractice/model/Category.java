package com.example.summerpractice.model;

import jakarta.persistence.*;
import lombok.*;

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
