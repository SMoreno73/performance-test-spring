package com.riwi.test.infraestructure.mappers;

import com.riwi.test.api.dto.request.QuestionRequest;
import com.riwi.test.api.dto.request.QuestionUpdate2Request;
import com.riwi.test.api.dto.request.QuestionUpdateRequest;
import com.riwi.test.api.dto.response.QuestionResponse;
import com.riwi.test.domain.entities.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "options", ignore = true),
            @Mapping(target = "surveyId.id", source = "surveyId"),
    })
    Question toQuestion(QuestionRequest questionRequest);

    QuestionResponse toQuestionResponse(Question question);

    @Mappings({
            @Mapping(target = "options", ignore = true),
            @Mapping(target = "surveyId.id", source = "surveyId"),
    })
    void updateFromQuestionRequest(QuestionUpdateRequest questionRequest, @MappingTarget Question question);

    @Mapping(target = "surveyId.id", source = "surveyId")
    void updateQuestionRequest(QuestionUpdate2Request questionRequest, @MappingTarget Question question);
}
