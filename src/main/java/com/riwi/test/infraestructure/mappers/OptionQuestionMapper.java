package com.riwi.test.infraestructure.mappers;

import com.riwi.test.api.dto.request.OptionQuestionRequest;
import com.riwi.test.api.dto.response.OptionQuestionResponse;
import com.riwi.test.domain.entities.OptionQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OptionQuestionMapper {
    @Mapping(target = "id", ignore = true)
    OptionQuestion toOptionQuestion(OptionQuestionRequest optionQuestionRequest);

    OptionQuestionResponse toOptionQuestionResponse(OptionQuestion optionQuestion);

    void updateFromOptionQuestionRequest(OptionQuestionRequest optionQuestionRequest, @MappingTarget OptionQuestion optionQuestion);
}
