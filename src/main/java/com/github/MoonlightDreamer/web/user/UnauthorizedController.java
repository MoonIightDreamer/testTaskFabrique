package com.github.MoonlightDreamer.web.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = UnauthorizedController.REST_API, produces = MediaType.APPLICATION_JSON_VALUE)
public class UnauthorizedController extends AbstractUserQuizController {
    static final String REST_API = "/api/guest/quizzes";

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void takeQuiz(@RequestBody String responses,
                         @RequestParam int userId,
                         @PathVariable int id) {
        super.takeQuiz(responses, userId, id, REST_API);
    }

    @GetMapping("/story/{id}")
    public List<String> showPassedQuiz(@PathVariable int id,
                                       @RequestParam int userId) {
        return super.showPassedQuiz(id, userId);
    }

    @GetMapping("/story")
    public List<List<String>> showAllPassedQuizzes(@RequestParam int userId) {
        return super.showAllPassedQuizzes(userId);
    }
}
