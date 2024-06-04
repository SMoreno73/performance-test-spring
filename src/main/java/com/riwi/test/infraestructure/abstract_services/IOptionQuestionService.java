package com.riwi.test.infraestructure.abstract_services;

import com.riwi.test.api.dto.request.OptionQuestionRequest;
import com.riwi.test.api.dto.response.OptionQuestionResponse;

import java.util.List;

public interface IOptionQuestionService extends
        CreateReadDeleteService<OptionQuestionRequest, OptionQuestionResponse, Long>,
        UpdateService<OptionQuestionRequest, OptionQuestionResponse, Long>
{
    void createOptionsFromQuestion(List<OptionQuestionRequest> files, Long questionId);
}
