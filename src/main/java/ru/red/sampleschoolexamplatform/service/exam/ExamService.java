package ru.red.sampleschoolexamplatform.service.exam;

import ru.red.sampleschoolexamplatform.model.exam.Exam;

public interface ExamService {
    Exam findExam(Long id);

    Exam loadExam(Long id);

    Exam saveExam(Exam exam);
}
