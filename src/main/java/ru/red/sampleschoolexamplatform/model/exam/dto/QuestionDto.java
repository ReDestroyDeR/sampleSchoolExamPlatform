package ru.red.sampleschoolexamplatform.model.exam.dto;

public record QuestionDto(Long id, String title, String question, Boolean manual, Byte weight, String[] answers) {
}
