package ru.red.sampleschoolexamplatform.dao.exam;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.red.sampleschoolexamplatform.model.exam.Exam;

import java.util.Optional;

public interface ExamDao extends JpaRepository<Exam, Long> {
    Optional<Exam> findFirstWithQuestionsById(Long id);

    Optional<Exam> findFirstWithQuestionsAndAnswersById(Long id);
}
