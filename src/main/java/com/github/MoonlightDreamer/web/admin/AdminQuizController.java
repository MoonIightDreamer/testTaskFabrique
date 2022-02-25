package com.github.MoonlightDreamer.web.admin;

import com.github.MoonlightDreamer.model.Quiz;
import com.github.MoonlightDreamer.repository.QuizRepository;
import com.github.MoonlightDreamer.util.ValidationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = AdminQuizController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminQuizController {

    @Autowired
    QuizRepository repository;

    public static final String REST_URL = "/api/admin/quiz";

    @GetMapping
    public List<Quiz> getAll() {
        log.info("get all quizzes");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> get(@PathVariable int id) {
        log.info("get quiz with id {}", id);
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete quiz with id {}", id);
        repository.deleteExisted(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@Valid @RequestBody Quiz quiz) {
        log.info("create {}", quiz);
        ValidationUtil.checkNew(quiz);
        quiz.setStartDate(LocalDate.now());
        repository.save(quiz);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Quiz quiz, @PathVariable int id) {
        log.info("update {} with id = {}", quiz, id);
        ValidationUtil.assureIdConsistent(quiz, id);
        repository.save(quiz);
    }
}
