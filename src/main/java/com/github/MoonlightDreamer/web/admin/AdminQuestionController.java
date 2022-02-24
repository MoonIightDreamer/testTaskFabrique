package com.github.MoonlightDreamer.web.admin;

import com.github.MoonlightDreamer.model.Question;
import com.github.MoonlightDreamer.model.Quiz;
import com.github.MoonlightDreamer.repository.QuestionRepository;
import com.github.MoonlightDreamer.repository.QuizRepository;
import com.github.MoonlightDreamer.to.QuestionTo;
import com.github.MoonlightDreamer.util.QuestionUtil;
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
@RequestMapping(value = AdminQuestionController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminQuestionController {
    static final String REST_URL = "api/admin/questions";

    @Autowired
    private QuestionRepository repository;

    @Autowired
    QuizRepository quizRepository;

    @GetMapping
    public List<Question> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> get(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        log.info("delete question with id {}", id);
        repository.deleteExisted(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@Valid @RequestBody QuestionTo questionTo) {
        log.info("create {}", questionTo);
        ValidationUtil.checkNew(questionTo);
        repository.save(QuestionUtil.createNewFromTo(questionTo, quizRepository));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Valid @RequestBody QuestionTo questionTo, @PathVariable int id) {
        log.info("update {} with id = {}", questionTo, id);
        ValidationUtil.assureIdConsistent(questionTo, id);
        Question updatedQuestion = repository.findById(id).orElse(null);
        assert updatedQuestion != null;
        QuestionUtil.updateFromTo(questionTo, updatedQuestion, quizRepository);
        repository.save(updatedQuestion);
    }
}
