package com.github.MoonlightDreamer.web.user;

import com.github.MoonlightDreamer.error.IllegalRequestDataException;
import com.github.MoonlightDreamer.error.NotFoundException;
import com.github.MoonlightDreamer.model.Quiz;
import com.github.MoonlightDreamer.model.UserQuiz;
import com.github.MoonlightDreamer.repository.QuizRepository;
import com.github.MoonlightDreamer.repository.UserQuizRepository;
import com.github.MoonlightDreamer.util.UserQuizUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class AbstractUserQuizController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected QuizRepository quizRepository;

    @Autowired
    protected UserQuizRepository UQRepository;

    public List<Quiz> getAllActiveQuizzes() {
        log.info("Getting all the active quizzes");
        return quizRepository.getActiveQuizzes();
    }

    public ResponseEntity<UserQuiz> takeQuiz(String userAnswers,
                                             int userId,
                                             int quizId, String restUrl) {
        log.info("Saving the answers to the survey {} from user number {}", quizId, userId);
        UserQuiz created = UQRepository.save(new UserQuiz(userId, quizId, userAnswers));
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(restUrl + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    public List<String> showPassedQuiz(int id,
                                       int userId) {
        log.info("showing the answers to the survey {} from user number {}", id, userId);
        List<String> result;
        try {
            result = UserQuizUtil.getListedAnswers(
                    UQRepository.getQuizResult(id, userId));
        } catch (RuntimeException e) {
            return (List.of("No surveys found with such userId"));
        }
        return result;
    }

    public List<List<String>> showAllPassedQuizzes(int userId) {
        log.info("Loading all the answered surveys from user number {}", userId);
        try {
            return UserQuizUtil.getListedAnswers(UQRepository.getAllQuizResults(userId));
        } catch (RuntimeException e) {
            return (List.of(List.of("No surveys found with such userId")));
        }
    }
}
