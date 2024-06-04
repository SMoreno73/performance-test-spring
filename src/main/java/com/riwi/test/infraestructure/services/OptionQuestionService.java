package com.riwi.test.infraestructure.services;

import com.riwi.test.api.dto.request.OptionFromQuestionRequest;
import com.riwi.test.api.dto.request.OptionQuestionRequest;
import com.riwi.test.domain.entities.OptionQuestion;
import com.riwi.test.domain.repositories.OptionQuestionRepository;
import com.riwi.test.domain.repositories.QuestionRepository;
import com.riwi.test.infraestructure.abstract_services.IOptionQuestionService;
import com.riwi.test.infraestructure.mappers.OptionQuestionMapper;
import com.riwi.test.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OptionQuestionService implements IOptionQuestionService {
    @Autowired
    private final OptionQuestionRepository optionQuestionRepository;

    @Autowired
    private final OptionQuestionMapper optionQuestionMapper;

    @Autowired
    private final QuestionRepository questionRepository;

    @Override
    public void createOptionsFromQuestion(List<OptionQuestionRequest> options, Long questionId) {
        for (OptionQuestionRequest optionsRequest : options) {
            OptionQuestion option = optionQuestionMapper.toOptionQuestion(optionsRequest);
            option.setQuestionId(questionRepository.findById(questionId)
                    .orElseThrow(() -> new IdNotFoundException("OPTION_QUESTION", questionId)));
            optionQuestionRepository.save(option);
        }
    }

    @Override
    public void updateOptionsFromQuestion(List<OptionFromQuestionRequest> options, Long questionId) {
        for (OptionFromQuestionRequest optionsRequest : options) {
            OptionQuestion option = optionQuestionMapper.toOptionQuestion(optionsRequest);
            option.setQuestionId(questionRepository.findById(questionId)
                    .orElseThrow(() -> new IdNotFoundException("OPTION_QUESTION", questionId)));
            optionQuestionRepository.save(option);
        }
    }
}
