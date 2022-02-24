package com.github.MoonlightDreamer.web.user;

import com.github.MoonlightDreamer.model.Quiz;
import com.github.MoonlightDreamer.repository.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = UserQuizController.REST_API, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserQuizController {
    static final String REST_API = "api/user/quizzes";

    @Autowired
    private QuizRepository quizRepository;

    @GetMapping("/{id}")
    public Quiz get(@PathVariable int id) {
        return quizRepository.getWithQuestions(id);
    }

    @GetMapping
    public List<Quiz> getAllActiveQuizzes() {
        return quizRepository.getActiveQuizzes();
    }

    @PostMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void takeQuiz(@RequestBody Map<Integer, String> responses, @PathVariable int id) {

    }
}
