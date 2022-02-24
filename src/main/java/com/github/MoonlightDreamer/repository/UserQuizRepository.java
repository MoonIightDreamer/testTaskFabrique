package com.github.MoonlightDreamer.repository;

import com.github.MoonlightDreamer.model.UserQuiz;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Tag(name = "User's quizzes story")
public interface UserQuizRepository extends BaseRepository<UserQuiz> {
    @Query("SELECT uq FROM UserQuiz uq WHERE uq.userId=?1 AND uq.quiz_id=?2")
    UserQuiz getQuizResult(int id, int quiz_id);

    @Query("SELECT uq FROM UserQuiz uq WHERE uq.userId=?1")
    List<UserQuiz> getAllQuizResults(int id);
}
