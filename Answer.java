package com.pollsystem.pollservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long questionId;
    private String selectedOption;
}
