package com.github.MoonlightDreamer.web;

import com.github.MoonlightDreamer.model.Quiz;
import com.github.MoonlightDreamer.repository.QuizRepository;
import com.github.MoonlightDreamer.to.QuizTo;
import com.github.MoonlightDreamer.util.JsonUtil;
import com.github.MoonlightDreamer.util.QuizUtil;
import com.github.MoonlightDreamer.web.admin.AdminQuizController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import static com.github.MoonlightDreamer.TestData.QuizTestData.*;
import static com.github.MoonlightDreamer.TestData.TestUtil.userHttpBasic;
import static com.github.MoonlightDreamer.TestData.UserTestData.admin;
import static com.github.MoonlightDreamer.TestData.UserTestData.user;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class QuizRestControllerTest extends AbstractRestControllerTest {

    private static final String REST_URL = AdminQuizController.REST_URL + "/";

    @Autowired
    private QuizRepository quizRepository;

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + QUIZ1_ID)
                .with(userHttpBasic(admin)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(QUIZ_MATCHER.contentJson(quiz1));
    }

    @Test
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL + QUIZ1_ID)
                .with(userHttpBasic(admin)))
                .andExpect(status().isNoContent());
        assertEquals(quizRepository.findById(QUIZ1_ID), Optional.empty());
    }

    @Test
    void userDelete() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL + QUIZ1_ID)
                .with(userHttpBasic(user)))
                .andExpect(status().isForbidden());
        assertEquals(quizRepository.getById(QUIZ1_ID), quiz1);
    }

    @Test
    void update() throws Exception {
        QuizTo updatedTo = new QuizTo(null, "имя",
                LocalDate.now().plus(2, ChronoUnit.DAYS), "описание");
        perform(MockMvcRequestBuilders.put(REST_URL + QUIZ1_ID)
                .with(userHttpBasic(admin))
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updatedTo)))
                .andDo(print())
                .andExpect(status().isNoContent());
        QUIZ_MATCHER.assertMatch(quizRepository.getById(QUIZ1_ID),
                QuizUtil.updateFromTo(new Quiz(quiz1), updatedTo));
    }
}
