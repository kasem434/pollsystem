package com.pollsystem.pollservice.service;

import com.pollsystem.pollservice.model.Question;
import com.pollsystem.pollservice.model.Answer;
import com.pollsystem.pollservice.repository.QuestionRepository;
import com.pollsystem.pollservice.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public PollService(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    public Question updateQuestion(Long id, Question updatedQuestion) {
        Question question = getQuestionById(id);
        question.setTitle(updatedQuestion.getTitle());
        question.setOptionA(updatedQuestion.getOptionA());
        question.setOptionB(updatedQuestion.getOptionB());
        question.setOptionC(updatedQuestion.getOptionC());
        question.setOptionD(updatedQuestion.getOptionD());
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Answer submitAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public List<Answer> getAnswersByUser(Long userId) {
        return answerRepository.findByUserId(userId);
    }

    public List<Answer> getAnswersByQuestion(Long questionId) {
        return answerRepository.findByQuestionId(questionId);
    }
}
