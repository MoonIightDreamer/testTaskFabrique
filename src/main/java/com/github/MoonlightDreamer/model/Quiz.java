package com.github.MoonlightDreamer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "quiz")
public class Quiz extends NamedEntity {

    @Column(name = "start_date", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    @NotNull
    private LocalDate endDate;

    @Column(name = "description", nullable = false)
    @NotNull
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quiz")//, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE) //https://stackoverflow.com/a/44988100/548473
    @JsonManagedReference
    private List<Question> questions;

    public Quiz() {

    }

    public Quiz(Integer id, String name, LocalDate startDate, LocalDate endDate, String description) {
        super(id, name);
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

}
