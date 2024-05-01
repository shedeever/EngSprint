package com.example.engsprint.model

/**
 * Класс модели теста, содержащий список вопросов и ответов.
 * Хранит данные о вопросах теста и предоставляет методы для их обработки.
 */
class TestModel {
    var questions: List<Question> = listOf()

    /**
     * Загружает вопросы для теста.
     * В реальном приложении данные могли бы загружаться из базы данных или внешнего API.
     */
    fun loadQuestions() {
        questions = listOf(
            Question("Как переводится слово 'apple'?", listOf("Яблоко", "Банан", "Вишня", "Груша"), "Яблоко"),
            Question("Какое время используется для выражения общих фактов?", listOf("Present Simple", "Past Simple", "Future Simple"), "Present Simple"),
            // Добавьте другие вопросы по аналогии
        )
    }
}

/**
 * Класс, представляющий отдельный вопрос в тесте.
 */
data class Question(val text: String, val options: List<String>, val correctAnswer: String)
