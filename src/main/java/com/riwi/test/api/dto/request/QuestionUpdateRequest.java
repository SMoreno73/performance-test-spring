package com.riwi.test.api.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionUpdateRequest {
    @NotBlank(message = "Text must not be null")
    private String text;

    @NotBlank(message = "Type must not be null")
    @Pattern(regexp = "CLOSED|OPEN", message = "The type must be CLOSED or OPEN.")
    private String type;

    @NotNull(message = "Survey id is required")
    @Min(value = 1, message = "Survey id must be greater than 0")
    private Long surveyId;

    @NotNull(message = "Active cannot be null")
    private boolean active;

    private List<OptionFromQuestionRequest> options;
}
