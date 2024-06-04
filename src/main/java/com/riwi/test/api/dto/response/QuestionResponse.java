package com.riwi.test.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {
    private Long id;
    private String text;
    private String type;
    private boolean active;
    private List<OptionQuestionResponse> options;
}
