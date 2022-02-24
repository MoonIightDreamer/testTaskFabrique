package com.github.MoonlightDreamer.util;

import com.github.MoonlightDreamer.model.UserQuiz;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@UtilityClass
public class UserQuizUtil {
    public static List<String> getListedAnswers(UserQuiz uq) {
        if(uq == null) throw new RuntimeException();
        return Arrays.asList(uq.getResponses().split("[%_ *&^]"));
    }

    public static List<List<String>> getListedAnswers(List<UserQuiz> uqList) {
        if(uqList == null || uqList.isEmpty()) throw new RuntimeException();
        List<List<String>> result = new ArrayList<>();
        uqList.forEach(uq -> result.add(getListedAnswers(uq)));
        return result;
    }
}
