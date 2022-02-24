package com.github.MoonlightDreamer.util;

import com.github.MoonlightDreamer.model.Question;
import com.github.MoonlightDreamer.repository.QuizRepository;
import com.github.MoonlightDreamer.to.QuestionTo;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;

@UtilityClass
public class QuestionUtil {

    public static Question createNewFromTo(QuestionTo questionTo, QuizRepository quizRepository) {
        Question result = new Question(questionTo.getId(), questionTo.getQuestionType(),
                questionTo.getQuestionText());
        result.setQuiz(quizRepository.getById(questionTo.getQuizId()));
        return result;
    }

    public static void updateFromTo(QuestionTo questionTo, Question question, QuizRepository quizRepository) {
        question.setQuestionType(questionTo.getQuestionType());
        question.setQuestionText(questionTo.getQuestionText());
        question.setQuiz(quizRepository.getById(questionTo.getQuizId()));
    }
}
