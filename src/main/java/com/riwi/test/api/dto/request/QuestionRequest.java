package com.riwi.test.api.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest extends QuestionUpdateRequest{
    @NotNull(message = "Options cannot be null")
    private List<OptionQuestionRequest> options;
}
