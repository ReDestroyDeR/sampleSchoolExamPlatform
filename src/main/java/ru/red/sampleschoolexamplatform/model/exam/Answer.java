package ru.red.sampleschoolexamplatform.model.exam;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Embeddable;

@Data
@Embeddable
@NoArgsConstructor
public class Answer {
    @NotNull
    private String text;

    private boolean correct;
}
