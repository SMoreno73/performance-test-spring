package com.riwi.test.infraestructure.abstract_services;

import com.riwi.test.api.dto.request.QuestionUpdateRequest;
import com.riwi.test.api.dto.response.QuestionResponse;

public interface IQuestionService extends
        CreateReadDeleteService<QuestionUpdateRequest, QuestionResponse, Long>,
        UpdateService<QuestionUpdateRequest, QuestionResponse, Long>
{
}
