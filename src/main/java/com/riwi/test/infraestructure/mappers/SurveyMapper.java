package com.riwi.test.infraestructure.mappers;

import com.riwi.test.api.dto.request.SurveyRequest;
import com.riwi.test.api.dto.response.SurveyResponse;
import com.riwi.test.domain.entities.Survey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SurveyMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "creationDate", ignore = true),
            @Mapping(target = "creatorId.id", source = "creatorId")
    })
    Survey toSurvey(SurveyRequest surveyRequest);

    SurveyResponse toSurveyResponse(Survey survey);

    @Mapping(target = "creatorId.id", source = "creatorId")
    void updateFromSurveyRequest(SurveyRequest surveyRequest, @MappingTarget Survey survey);
}
