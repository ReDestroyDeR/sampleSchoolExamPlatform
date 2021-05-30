package ru.red.sampleschoolexamplatform.service.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.red.sampleschoolexamplatform.dao.exam.ExamDao;
import ru.red.sampleschoolexamplatform.model.exam.Exam;

@Service
public class ExamServiceImpl implements ExamService {
    private final ExamDao examDao;

    @Autowired
    public ExamServiceImpl(ExamDao examDao) {
        this.examDao = examDao;
    }


    @Override
    public Exam findExam(Long id) {
        return examDao.findById(id).orElse(null);
    }

    @Override
    public Exam loadExam(Long id) {
        return examDao.findFirstWithQuestionsAndAnswersById(id).orElse(null);
    }

    @Override
    public Exam saveExam(Exam exam) {
        return examDao.save(exam);
    }
}
