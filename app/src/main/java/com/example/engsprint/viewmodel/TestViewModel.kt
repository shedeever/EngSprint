package com.example.engsprint.viewmodel

    import androidx.lifecycle.ViewModel
    import com.example.engsprint.model.Question
    import com.example.engsprint.model.TestModel

/**
 * ViewModel для экрана тестирования.
 * Управляет логикой прохождения теста, включая выбор ответов и подсчет результатов.
 */
class TestViewModel : ViewModel() {
    private val testModel = TestModel()
    var currentQuestionIndex = 0
        private set
    var score = 0
        private set

    init {
        testModel.loadQuestions()
    }

    val currentQuestion: Question
        get() = testModel.questions[currentQuestionIndex]

    /**
     * Проверяет выбранный ответ и переходит к следующему вопросу.
     */
    fun submitAnswer(answer: String) {
        if (answer == currentQuestion.correctAnswer) {
            score++
        }
        if (currentQuestionIndex < testModel.questions.size - 1) {
            currentQuestionIndex++
        } else {
            // Обработка завершения теста
        }
    }
}
