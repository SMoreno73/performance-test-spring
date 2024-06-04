package com.riwi.test.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11)")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String text;

    @Column(length = 50)
    private String type;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "survey_id")
    private Survey surveyId;

    private boolean active;

    @OneToMany(
            mappedBy = "questionId",
            cascade = CascadeType.ALL,
            orphanRemoval = false,
            fetch = FetchType.EAGER
    )
    private List<OptionQuestion> optionsQuestions = new ArrayList<>();
}
