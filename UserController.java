package com.pollsystem.pollservice.controller;

import com.pollsystem.pollservice.model.Answer;
import com.pollsystem.pollservice.model.User;
import com.pollsystem.pollservice.service.UserService;
import com.pollsystem.pollservice.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AnswerService answerService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        answerService.deleteAnswersByUserId(id);
    }

    @GetMapping("/{id}/answers")
    public List<Answer> getUserAnswers(@PathVariable Long id) {
        return answerService.getAnswersByUserId(id);
    }
}