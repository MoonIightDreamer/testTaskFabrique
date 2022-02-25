package com.github.MoonlightDreamer.TestData;

import com.github.MoonlightDreamer.MatcherFactory;
import com.github.MoonlightDreamer.model.Quiz;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class QuizTestData {

    public static final MatcherFactory.Matcher<Quiz> QUIZ_MATCHER
            = MatcherFactory.usingIgnoringFieldsComparator(Quiz.class, "questions", "startDate");

    public static final int NOT_FOUND = 10;
    public static final int QUIZ1_ID = 1;

    public static final Quiz quiz1 = new Quiz(1, "Уровень IQ",
            LocalDate.of(2022,2,14),
            LocalDate.of(2022,2,24),
            "Ответьте на пару простых логических вопросов!");

    public static Quiz getUpdated() {
        return new Quiz(QUIZ1_ID, "Обновленный", quiz1.getStartDate(),
                quiz1.getEndDate().plus(2, ChronoUnit.DAYS), "Обновленное описание");
    }

    public static Quiz getNew() {
        return new Quiz(null, "Новый", LocalDate.of(2022, 2, 25),
                LocalDate.of(2022, 3, 25), "Новое описание");
    }
}
