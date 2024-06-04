package com.riwi.test.api.controllers;

import com.riwi.test.api.dto.request.SurveyRequest;
import com.riwi.test.api.dto.response.SurveyResponse;
import com.riwi.test.infraestructure.abstract_services.ISurveyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/surveys")
@AllArgsConstructor
public class SurveyController {
    @Autowired
    private final ISurveyService surveyService;

    @GetMapping
    public ResponseEntity<Page<SurveyResponse>> getByCreateBetween(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(name = "startDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(name = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(surveyService.getByCreationDateBetween(startDate, endDate, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<SurveyResponse>> getSurvey(@PathVariable Long id) {
        return ResponseEntity.ok(surveyService.getById(id));
    }

    @PostMapping
    public ResponseEntity<SurveyResponse> saveSurvey(@Validated @RequestBody SurveyRequest surveyRequest) {
        return ResponseEntity.ok(surveyService.create(surveyRequest));
    }
}
