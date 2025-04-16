package com.pollsystem.pollservice.controller;

import com.pollsystem.pollservice.model.Question;
import com.pollsystem.pollservice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")

public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

}
