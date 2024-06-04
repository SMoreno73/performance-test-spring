package com.riwi.test.domain.repositories;

import com.riwi.test.domain.entities.OptionQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionQuestionRepository extends JpaRepository<OptionQuestion, Long> {
}
