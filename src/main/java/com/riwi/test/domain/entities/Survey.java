package com.riwi.test.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11)")
    private Long id;

    @Column(unique = true, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = false, updatable = false)
    @CreationTimestamp
    private Date creationDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "creator_id")
    private User creatorId;

    private boolean active;

    @OneToMany(
            mappedBy = "surveyId",
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Question> questions = new ArrayList<>();
}
