package ru.red.sampleschoolexamplatform.controller.exam.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.red.sampleschoolexamplatform.dto.exam.ExamDto;
import ru.red.sampleschoolexamplatform.model.exam.Answer;
import ru.red.sampleschoolexamplatform.model.exam.Exam;
import ru.red.sampleschoolexamplatform.model.exam.Question;
import ru.red.sampleschoolexamplatform.service.exam.ExamService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/exams")
public class ExamRestController {
    private final ExamService examService;

    @Autowired
    public ExamRestController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping
    public ResponseEntity<List<Exam>> getAllExams() {
        return new ResponseEntity<>(examService.getAllExams(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Exam> findExam(@PathVariable Long id) {
        return new ResponseEntity<>(examService.getExam(id), HttpStatus.OK);
    }

    @GetMapping("/load/{id}")
    public ResponseEntity<Exam> loadExam(@PathVariable Long id) {
        return new ResponseEntity<>(examService.findExam(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Exam> saveExam(@RequestBody ExamDto examDto) {
        Exam exam = new Exam();
        exam.setId(examDto.id());
        exam.setTitle(examDto.title());

        // Here we're mapping DataTransferObject arrays to their respective Lists of Models representation
        List<Question> questionList = Arrays
                .stream(examDto.questions())
                .map(questionDto -> {
            Question question = new Question();
            question.setId(questionDto.id());
            question.setTitle(questionDto.title());
            question.setWeight(questionDto.weight());
            question.setQuestion(questionDto.question());
            question.setAnswers(Arrays
                    .stream(questionDto.answers())
                    .map(answerDto -> {
                        Answer answer = new Answer();
                        answer.setText(answerDto.text());
                        answer.setCorrect(answerDto.correct());
                        return answer;
                    })
                    .collect(Collectors.toList()));
            question.setExam(exam);
            return question;
            })
                .collect(Collectors.toList());

        exam.setQuestions(questionList);

        return new ResponseEntity<>(examService.saveExam(exam), HttpStatus.OK);
    }
}
