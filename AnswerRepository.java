package com.pollsystem.pollservice.repository;

import com.pollsystem.pollservice.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByUserId(Long userId);
    List<Answer> findByQuestionId(Long questionId);
}
