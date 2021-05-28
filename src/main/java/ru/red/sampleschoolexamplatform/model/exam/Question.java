package ru.red.sampleschoolexamplatform.model.exam;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {
    @Id
    private Long id;

    private String title;
    private String question;
    private String answers;

    @Transient
    private StringSet answersSet;

}
