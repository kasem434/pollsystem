package com.pollsystem.pollservice.service;

import com.pollsystem.pollservice.model.Answer;
import com.pollsystem.pollservice.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public Answer submitAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public List<Answer> getAnswersByUserId(Long userId) {
        return answerRepository.findByUserId(userId);
    }

    public void deleteAnswersByUserId(Long userId) {
        List<Answer> answers = answerRepository.findByUserId(userId);
        answerRepository.deleteAll(answers);
    }

    public Map<String, Long> countVotesByQuestion(Long questionId) {
        List<Answer> answers = answerRepository.findByQuestionId(questionId);
        return answers.stream()
                .collect(Collectors.groupingBy(Answer::getSelectedOption, Collectors.counting()));
    }
}
