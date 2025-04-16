package com.pollsystem.pollservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    private String title;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
}
