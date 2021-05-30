package ru.red.sampleschoolexamplatform.model.exam;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String question;

    // Means that question is to be checked manually
    private boolean manual;

    // Can't be null so == 0 == default weight == 100 <-> weights
    // Constrained by number of English characters -1 because we're counting from 0
    @Size(max=25)
    private byte weight;

    @ManyToOne(fetch = FetchType.LAZY)
    private Exam exam;

    @Nullable
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "question_answers", joinColumns = @JoinColumn(name="id"))
    private List<Answer> answers;

}
