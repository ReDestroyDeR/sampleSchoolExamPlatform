package ru.red.sampleschoolexamplatform.dto.exam;

public record ExamDto(Long id, String title, QuestionDto[] questions) {
}
