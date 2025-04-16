package com.pollsystem.pollservice.controller;

import com.pollsystem.pollservice.model.Question;
import com.pollsystem.pollservice.model.Answer;
import com.pollsystem.pollservice.service.PollService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/polls")
public class PollController {
    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping("/questions")
    public Question createQuestion(@RequestBody Question question) {
        return pollService.createQuestion(question);
    }

    @GetMapping("/questions/{id}")
    public Question getQuestion(@PathVariable Long id) {
        return pollService.getQuestionById(id);
    }

    @PutMapping("/questions/{id}")
    public Question updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        return pollService.updateQuestion(id, question);
    }

    @DeleteMapping("/questions/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        pollService.deleteQuestion(id);
    }

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return pollService.getAllQuestions();
    }

    @PostMapping("/answers")
    public Answer submitAnswer(@RequestBody Answer answer) {
        return pollService.submitAnswer(answer);
    }

    @GetMapping("/answers/user/{userId}")
    public List<Answer> getAnswersByUser(@PathVariable Long userId) {
        return pollService.getAnswersByUser(userId);
    }

    @GetMapping("/answers/question/{questionId}")
    public List<Answer> getAnswersByQuestion(@PathVariable Long questionId) {
        return pollService.getAnswersByQuestion(questionId);
    }
}
