package com.pollsystem.pollservice.controller;

import com.pollsystem.pollservice.model.Answer;
import com.pollsystem.pollservice.repository.AnswerRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerRepository answerRepository;

    public AnswerController(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @PostMapping
    public Answer submitAnswer(@RequestBody Answer answer) {
        return answerRepository.save(answer);
    }
}
