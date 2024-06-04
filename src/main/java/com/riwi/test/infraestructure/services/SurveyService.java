package com.riwi.test.infraestructure.services;

import com.riwi.test.api.dto.request.SurveyRequest;
import com.riwi.test.api.dto.response.SurveyResponse;
import com.riwi.test.domain.entities.Survey;
import com.riwi.test.domain.entities.User;
import com.riwi.test.domain.repositories.SurveyRepository;
import com.riwi.test.domain.repositories.UserRepository;
import com.riwi.test.infraestructure.abstract_services.ISurveyService;
import com.riwi.test.infraestructure.mappers.SurveyMapper;
import com.riwi.test.util.exeptions.IdNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class SurveyService implements ISurveyService{
    @Autowired
    private final SurveyRepository surveyRepository;

    @Autowired
    private final SurveyMapper surveyMapper;

    @Autowired
    private final UserRepository userRepository;

        @Override
        public SurveyResponse create(SurveyRequest surveyRequest) {
            Survey survey = surveyMapper.toSurvey(surveyRequest);
            User user = userRepository.findById(surveyRequest.getCreatorId())
                    .orElseThrow(() -> new IdNotFoundException("USER", surveyRequest.getCreatorId()));
            survey.setCreatorId(user);

            Survey saveSurvey = surveyRepository.save(survey);
            if (Objects.nonNull(user.getEmail()))
                emailHelper.sendEmail(user.getEmail(), "Survey had been create: "+surveyRequest.getTitle(),"Thank you for this new survey", LocalDateTime.now());
            return surveyMapper.toSurveyResponse(saveSurvey);
        }

        @Override
        public Page<SurveyResponse> getAll(Pageable pageable) {
            return null;
        }

        @Override
        public Optional<SurveyResponse> getById(Long id) {
            Optional<Survey> survey = surveyRepository.findById(id);
            if (survey.isEmpty()) throw new IdNotFoundException("SURVEY", id);
            return survey.map(surveyMapper::toSurveyResponse);
        }
}

