package ru.red.sampleschoolexamplatform.dto.exam;

public record QuestionDto(Long id, String title, String question, Boolean manual, Byte weight, String[] answers) {
}
