package com.riwi.test.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OptionQuestionRequest {
    @NotBlank(message = "Text must not be null")
    private String text;

    @NotBlank(message = "Active cannot be null")
    @Pattern(regexp = "true|false", message = "The type must be true or false")
    private String active;
}
