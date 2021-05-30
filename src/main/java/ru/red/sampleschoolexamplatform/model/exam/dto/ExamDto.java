package ru.red.sampleschoolexamplatform.model.exam.dto;

public record ExamDto(Long id, String title, QuestionDto[] questions) {
}
