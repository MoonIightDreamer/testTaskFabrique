package com.github.MoonlightDreamer.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "USER_QUIZ")
@NoArgsConstructor
@AllArgsConstructor
public class UserQuiz extends BaseEntity {

    @NotNull
    @Column(name = "user_id")
    Integer userId;

    @NotNull
    @Column(name = "quiz_id")
    Integer quiz_id;

    @NotNull
    @Column(name = "user_responses")
    String responses;
}
