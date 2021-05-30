package ru.red.sampleschoolexamplatform.dao.exam;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.red.sampleschoolexamplatform.model.exam.Exam;

import java.util.Optional;

public interface ExamDao extends JpaRepository<Exam, Long> {
    @NotNull
    @EntityGraph("")
    Optional<Exam> findById(@NotNull Long id);

    @NotNull
    Exam getById(@NotNull Long id);
}
