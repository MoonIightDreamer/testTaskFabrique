package com.github.MoonlightDreamer.TestData;

import com.github.MoonlightDreamer.MatcherFactory;
import com.github.MoonlightDreamer.model.Quiz;

import java.time.LocalDate;

public class QuizTestData {

    public static final MatcherFactory.Matcher<Quiz> QUIZ_MATCHER = MatcherFactory.usingEqualsComparator(Quiz.class);

    public static final int NOT_FOUND = 10;
    public static final int QUIZ1_ID = 1;

    public static final Quiz quiz1 = new Quiz(1, "Уровень IQ",
            LocalDate.of(2022,2,14),
            LocalDate.of(2022,2,24),
            "Ответьте на пару простых логических вопросов!");
}
