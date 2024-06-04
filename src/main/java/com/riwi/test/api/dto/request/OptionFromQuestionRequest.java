package com.riwi.test.api.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OptionFromQuestionRequest {
    @NotNull(message = "Id is required")
    @Min(value = 1, message = "Id must be greater than 0")
    private Long id;
    @NotBlank(message = "Text must not be null")
    private String text;

    @NotNull(message = "Active cannot be null")
    private boolean active;
}
