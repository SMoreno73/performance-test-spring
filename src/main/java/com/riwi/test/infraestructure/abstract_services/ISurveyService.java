package com.riwi.test.infraestructure.abstract_services;

import com.riwi.test.api.dto.request.SurveyRequest;
import com.riwi.test.api.dto.response.SurveyResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface ISurveyService extends
        CreateReadService<SurveyRequest, SurveyResponse, Long>
{
    Page<SurveyResponse> getByCreationDateBetween(Date startDate, Date endDate,Pageable pageable);
}
