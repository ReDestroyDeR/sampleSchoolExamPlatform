package ru.red.sampleschoolexamplatform.model.exam;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Set;

@Entity
@Table(name = "exam")
public class Exam {
    @Id
    private Long id;

    private String title;

    @Transient
    private Set<Question> questions;
}
