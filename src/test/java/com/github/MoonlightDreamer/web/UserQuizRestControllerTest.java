package com.github.MoonlightDreamer.web;

import com.github.MoonlightDreamer.repository.UserQuizRepository;
import com.github.MoonlightDreamer.web.user.UserQuizController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.github.MoonlightDreamer.TestData.QuizTestData.QUIZ1_ID;
import static com.github.MoonlightDreamer.TestData.TestUtil.userHttpBasic;
import static com.github.MoonlightDreamer.TestData.UserQuizTestData.*;
import static com.github.MoonlightDreamer.TestData.UserTestData.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserQuizRestControllerTest extends AbstractRestControllerTest{

    private static final String REST_URL = UserQuizController.REST_API + "/";

    @Autowired
    UserQuizRepository repository;

    @Test
    void get() throws Exception{
        perform(MockMvcRequestBuilders.get(REST_URL + "/story/" + QUIZ1_ID)
                .with(userHttpBasic(admin)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
