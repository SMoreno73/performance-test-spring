package com.riwi.test.api.controllers;

import com.riwi.test.api.dto.request.QuestionRequest;
import com.riwi.test.api.dto.request.QuestionUpdate2Request;
import com.riwi.test.api.dto.request.QuestionUpdateRequest;
import com.riwi.test.api.dto.response.QuestionResponse;
import com.riwi.test.infraestructure.abstract_services.IQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
@AllArgsConstructor
public class QuestionController {
    @Autowired
    private final IQuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionResponse> saveQuestion(@Validated @RequestBody QuestionRequest userRequest) {
        return ResponseEntity.ok(questionService.create(userRequest));
    }

    @GetMapping
    public ResponseEntity<Page<QuestionResponse>> getAllQuestions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        if (page != 0)
            pageable = PageRequest.of(page - 1, size);
        return ResponseEntity.ok(questionService.getAll(pageable));
    }

    @PutMapping("/{id}/options")
    public ResponseEntity<QuestionResponse> updateQuestion(
            @PathVariable Long id,
            @Validated @RequestBody QuestionUpdateRequest userRequest
    ) {
        return ResponseEntity.ok(questionService.update(id, userRequest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<QuestionResponse> updateQuestion2(
            @PathVariable Long id,
            @Validated @RequestBody QuestionUpdate2Request userRequest
    ) {
        return ResponseEntity.ok(questionService.updateQuestionRequest(userRequest, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
