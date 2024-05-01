package com.example.engsprint.model

/**
 * Класс модели, хранящий данные курсов и предоставляющий методы для расчета статистики.
 */
class StatisticModel(var scores: List<Double>) {
    /**
     * Рассчитывает средний балл по курсу.
     * Возвращает среднее значение.
     */
    fun calculateAverage(): Double {
        return if (scores.isNotEmpty()) scores.average() else 0.0
    }

    /**
     * Определяет максимальный балл по курсу.
     * Возвращает максимальное значение.
     */
    fun findMaximumScore(): Double {
        return scores.maxOrNull() ?: 0.0
    }

    /**
     * Определяет минимальный балл по курсу.
     * Возвращает минимальное значение.
     */
    fun findMinimumScore(): Double {
        return scores.minOrNull() ?: 0.0
    }
}
