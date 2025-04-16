package com.pollsystem.pollservice.repository;

import com.pollsystem.pollservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
