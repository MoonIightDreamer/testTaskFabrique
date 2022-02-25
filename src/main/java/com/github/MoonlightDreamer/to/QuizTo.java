package com.github.MoonlightDreamer.to;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.apache.tomcat.jni.Local;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
@EqualsAndHashCode(callSuper = true)
public class QuizTo extends NamedTo {
    @NotNull
    LocalDate endDate;

    @NotNull
    String description;

    public QuizTo(Integer id, String name, LocalDate endDate, String description) {
        super(id, name);
        this.endDate = endDate;
        this.description = description;
    }
}
