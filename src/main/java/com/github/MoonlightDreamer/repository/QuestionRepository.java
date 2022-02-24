package com.github.MoonlightDreamer.repository;

import com.github.MoonlightDreamer.model.Question;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Questions Controller")
public interface QuestionRepository extends BaseRepository<Question> {
}
