package com.riwi.test.api.dto.request;

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
public class OptionQuestionRequest {
    @NotBlank(message = "Text must not be null")
    private String text;

    @NotNull(message = "Active cannot be null")
    private boolean active;
}
