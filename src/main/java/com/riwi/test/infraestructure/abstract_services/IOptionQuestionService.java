package com.riwi.test.infraestructure.abstract_services;

import com.riwi.test.api.dto.request.OptionFromQuestionRequest;
import com.riwi.test.api.dto.request.OptionQuestionRequest;
import com.riwi.test.api.dto.response.OptionQuestionResponse;

import java.util.List;

public interface IOptionQuestionService
{
    void createOptionsFromQuestion(List<OptionQuestionRequest> options, Long questionId);
    void updateOptionsFromQuestion(List<OptionFromQuestionRequest> options, Long questionId);
}
