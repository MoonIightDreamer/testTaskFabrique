package com.github.MoonlightDreamer.TestData;

import com.github.MoonlightDreamer.MatcherFactory;
import com.github.MoonlightDreamer.model.UserQuiz;

import static com.github.MoonlightDreamer.TestData.QuizTestData.QUIZ1_ID;
import static com.github.MoonlightDreamer.TestData.UserTestData.USER_ID;

public class UserQuizTestData {
    public static final MatcherFactory.Matcher<UserQuiz> UQ_MATCHER
            = MatcherFactory.usingEqualsComparator(UserQuiz.class);

    public static final int UQ_ID1 = 1;
    public static final int NOT_FOUND = 20;

    public static final String ANSWERS1 = "1%2%1%5%7%132%стефан";

    public static final UserQuiz uq1 = new UserQuiz(UQ_ID1, USER_ID,QUIZ1_ID, ANSWERS1);
}
