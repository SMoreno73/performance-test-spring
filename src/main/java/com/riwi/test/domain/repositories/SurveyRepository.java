package com.riwi.test.domain.repositories;

import com.riwi.test.domain.entities.Survey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    Page<Survey> findByCreationDateBetween(Date startDate, Date endDate, Pageable pageable);
}
