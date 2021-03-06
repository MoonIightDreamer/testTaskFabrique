package com.github.MoonlightDreamer.to;

import com.github.MoonlightDreamer.model.QuestionType;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Value
@EqualsAndHashCode(callSuper = true)
public class QuestionTo extends BaseTo {
    @NotNull
    @Enumerated(EnumType.STRING)
    QuestionType questionType;

    @NotNull
    String questionText;

    int quizId;

    public QuestionTo(Integer id, QuestionType questionType, String questionText, int quizId) {
        super(id);
        this.questionType = questionType;
        this.questionText = questionText;
        this.quizId = quizId;
        Map<String, Map<Integer, String>> map = new HashMap<String, Map<Integer, String>>();
    }
}
