package com.github.MoonlightDreamer.web.user;

import com.github.MoonlightDreamer.model.Quiz;
import com.github.MoonlightDreamer.model.UserQuiz;
import com.github.MoonlightDreamer.web.AuthUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = UserQuizController.REST_API, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserQuizController extends AbstractUserQuizController {
    public static final String REST_API = "/api/user/quizzes";

    @GetMapping
    public List<Quiz> getAllActiveQuizzes() {
        return super.getAllActiveQuizzes();
    }

    @PostMapping(value = "/{quizId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserQuiz> takeQuiz(@RequestBody String userAnswers,
                                             @AuthenticationPrincipal AuthUser authUser,
                                             @PathVariable int quizId) {
        return super.takeQuiz(userAnswers, authUser.id(), quizId, REST_API);
    }

    @GetMapping("/story/{id}")
    public List<String> showPassedQuiz(@PathVariable int id,
                                       @AuthenticationPrincipal AuthUser authUser) {
        return super.showPassedQuiz(id, authUser.id());
    }

    @GetMapping("/story")
    public List<List<String>> showAllPassedQuizzes(@AuthenticationPrincipal AuthUser authUser) {
        return super.showAllPassedQuizzes(authUser.id());
    }
}
