package com.github.MoonlightDreamer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name="question")
public class Question extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name="question_type")
    @NotNull
    private QuestionType questionType;

    @Column(name="question_text")
    @NotBlank
    private String questionText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    @NotNull
    private Quiz quiz;

    public Question() {

    }

    public Question(Integer id, QuestionType questionType, String questionText) {
        super(id);
        this.questionType = questionType;
        this.questionText = questionText;
    }

}
