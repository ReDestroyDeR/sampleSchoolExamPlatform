package ru.red.sampleschoolexamplatform.service.exam;

import ru.red.sampleschoolexamplatform.model.exam.Exam;

import java.util.List;

public interface ExamService {
    Exam getExam(Long id);

    Exam findExam(Long id);

    Exam saveExam(Exam exam);

    List<Exam> getAllExams();
}
