package com.github.MoonlightDreamer.util;

import com.github.MoonlightDreamer.model.Quiz;
import com.github.MoonlightDreamer.to.QuizTo;

import java.time.LocalDate;

public class QuizUtil {
    public static Quiz createNewFromTo(QuizTo quizTo) {
        return new Quiz(null, quizTo.getName(), LocalDate.now(), quizTo.getEndDate(), quizTo.getDescription());
    }

    public static Quiz updateFromTo(Quiz quiz, QuizTo quizTo) {
        quiz.setName(quizTo.getName());
        quiz.setEndDate(quizTo.getEndDate());
        quiz.setDescription(quizTo.getDescription());
        return quiz;
    }
}
