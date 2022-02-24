package com.github.MoonlightDreamer.repository;

import com.github.MoonlightDreamer.model.Quiz;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Tag(name = "Quizzes Controller")
public interface QuizRepository extends BaseRepository<Quiz> {
    @EntityGraph(attributePaths = {"questions"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT q FROM Quiz q WHERE q.id=?1")
    Quiz getWithQuestions(int id);

    @EntityGraph(attributePaths = {"questions"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT q FROM Quiz q WHERE q.endDate > CURRENT_DATE")
    List<Quiz> getActiveQuizzes();
}
