package com.riwi.test.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SurveyResponse {
    private Long id;
    private String title;
    private String description;
    private Date creationDate;
}
