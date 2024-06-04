package com.riwi.test.infraestructure.abstract_services;

import com.riwi.test.api.dto.request.SurveyRequest;
import com.riwi.test.api.dto.response.SurveyResponse;

public interface ISurveyService extends
        CreateReadDeleteService<SurveyRequest, SurveyResponse, Long>,
        UpdateService<SurveyRequest, SurveyResponse, Long>
{
}
