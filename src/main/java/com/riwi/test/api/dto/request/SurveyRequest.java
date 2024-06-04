package com.riwi.test.api.dto.request;

import com.riwi.test.domain.entities.User;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SurveyRequest {
    @NotBlank(message = "Title must not be null")
    @Size(
            max = 255,
            message = "Title cannot be longer than 255 characters."
    )
    private String title;

    @NotBlank(message = "Description must not be null")
    private String description;

    @NotNull(message = "Creator id is required")
    @Min(value = 1, message = "Creator id must be greater than 0")
    private Long creatorId;

    @NotBlank(message = "Active cannot be null")
    @Pattern(regexp = "true|false", message = "The type must be true or false")
    private String active;
}
