package com.riwi.test.api.dto.request;

import com.riwi.test.domain.entities.User;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "Active cannot be null")
    private boolean active;
}
