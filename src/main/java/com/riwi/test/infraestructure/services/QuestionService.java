package com.riwi.test.infraestructure.services;

import com.riwi.test.api.dto.request.QuestionRequest;
import com.riwi.test.api.dto.request.QuestionUpdate2Request;
import com.riwi.test.api.dto.request.QuestionUpdateRequest;
import com.riwi.test.api.dto.response.QuestionResponse;
import com.riwi.test.domain.entities.Question;
import com.riwi.test.domain.entities.Survey;
import com.riwi.test.domain.repositories.QuestionRepository;
import com.riwi.test.domain.repositories.SurveyRepository;
import com.riwi.test.infraestructure.abstract_services.IOptionQuestionService;
import com.riwi.test.infraestructure.abstract_services.IQuestionService;
import com.riwi.test.infraestructure.mappers.QuestionMapper;
import com.riwi.test.util.enums.Type;
import com.riwi.test.util.exeptions.IdNotFoundException;
import com.riwi.test.util.exeptions.OptionsAreNull;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class QuestionService implements IQuestionService {
    @Autowired
    private final QuestionRepository questionRepository;

    @Autowired
    private final QuestionMapper questionMapper;

    @Autowired
    private final SurveyRepository surveyRepository;

    @Autowired
    private final IOptionQuestionService optionQuestionService;


    @Override
    public QuestionResponse create(QuestionRequest questionRequest) {
        Question question = questionMapper.toQuestion(questionRequest);
        Survey existingSurvey = surveyRepository.findById(questionRequest.getSurveyId())
                .orElseThrow(() -> new IdNotFoundException("SURVEY", questionRequest.getSurveyId()));
        question.setSurveyId(existingSurvey);

        Question saveQuestion = questionRepository.save(question);

        if (Type.CLOSED == Type.valueOf(questionRequest.getType())) {
            if (questionRequest.getOptions() != null)
                optionQuestionService.createOptionsFromQuestion(questionRequest.getOptions(), saveQuestion.getId());
            else throw new OptionsAreNull();
        }
        return questionMapper.toQuestionResponse(saveQuestion);
    }

    @Override
    public QuestionResponse update(Long id, QuestionUpdateRequest questionRequest) {
        Question existingQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("QUESTION", id));
        Survey existingSurvey = surveyRepository.findById(questionRequest.getSurveyId())
                .orElseThrow(() -> new IdNotFoundException("SURVEY", questionRequest.getSurveyId()));
        existingQuestion.setSurveyId(existingSurvey);

        questionMapper.updateFromQuestionRequest(questionRequest, existingQuestion);
        Question updateQuestion = questionRepository.save(existingQuestion);
        if (Type.CLOSED == Type.valueOf(questionRequest.getType())) {
            if (questionRequest.getOptions() != null)
                optionQuestionService.updateOptionsFromQuestion(questionRequest.getOptions(), updateQuestion.getId());
            else throw new OptionsAreNull();
        }
        return questionMapper.toQuestionResponse(updateQuestion);
    }

    @Override
    public Page<QuestionResponse> getAll(Pageable pageable) {
        Page<Question> questionPage = questionRepository.findAll(pageable);
        return questionPage.map(questionMapper::toQuestionResponse);
    }

    @Override
    public Optional<QuestionResponse> getById(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isEmpty()) throw new IdNotFoundException("QUESTION", id);
        return question.map(questionMapper::toQuestionResponse);
    }

    @Override
    public void delete(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public QuestionResponse updateQuestionRequest(QuestionUpdate2Request questionRequest, Long id) {
        Question existingQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("QUESTION", id));
        Survey existingSurvey = surveyRepository.findById(questionRequest.getSurveyId())
                .orElseThrow(() -> new IdNotFoundException("SURVEY", questionRequest.getSurveyId()));
        existingQuestion.setSurveyId(existingSurvey);

        questionMapper.updateQuestionRequest(questionRequest, existingQuestion);
        Question updateQuestion = questionRepository.save(existingQuestion);

        return questionMapper.toQuestionResponse(updateQuestion);
    }
}
