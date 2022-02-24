package com.github.MoonlightDreamer.web;

import com.github.MoonlightDreamer.repository.QuizRepository;
import com.github.MoonlightDreamer.web.admin.AdminQuizController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.github.MoonlightDreamer.TestData.QuizTestData.QUIZ1_ID;
import static com.github.MoonlightDreamer.TestData.TestUtil.userHttpBasic;
import static com.github.MoonlightDreamer.TestData.UserTestData.admin;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class QuizRestControllerTest extends AbstractRestControllerTest {

    private static final String REST_URL = "/" + AdminQuizController.REST_URL + "/";

    @Autowired
    private QuizRepository quizRepository;

    @Test
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL + QUIZ1_ID)
                .with(userHttpBasic(admin)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE));
    }

}
