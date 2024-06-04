package com.riwi.test.infraestructure.services;

import com.riwi.test.api.dto.request.OptionFromQuestionRequest;
import com.riwi.test.api.dto.request.OptionQuestionRequest;
import com.riwi.test.domain.repositories.OptionQuestionRepository;
import com.riwi.test.infraestructure.abstract_services.IOptionQuestionService;
import com.riwi.test.infraestructure.mappers.OptionQuestionMapper;
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
    @Override
    public void createOptionsFromQuestion(List<OptionQuestionRequest> files, Long questionId) {

    }

    @Override
    public void updateOptionsFromQuestion(List<OptionFromQuestionRequest> files, Long questionId) {

    }
}
