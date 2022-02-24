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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
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

    public static List<String> getListedAnswers(UserQuiz uq) {
        return Arrays.asList(uq.responses.split("%"));
    }

    public static List<List<String>> getListedAnswers(List<UserQuiz> uqList) {
        List<List<String>> result = new ArrayList<>();
        uqList.
                forEach(uq -> result.add(getListedAnswers(uq)));
        return result;
    }
}
