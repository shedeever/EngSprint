package com.example.engsprint.viewmodel

import androidx.lifecycle.ViewModel
import com.example.engsprint.model.StatisticModel

/**
 * ViewModel для страницы статистики курсов.
 * Обрабатывает логику отображения статистики, основываясь на данных модели.
 */
class StatisticViewModel : ViewModel() {
    private val statisticsModel = StatisticModel(listOf(88.0, 92.5, 75.0, 99.0))

    var averageScore: Double = 0.0
        private set
    var maximumScore: Double = 0.0
        private set
    var minimumScore: Double = 0.0
        private set

    /**
     * Вызывает методы модели для расчета статистики и обновляет UI.
     */
    fun calculateStatistics() {
        averageScore = statisticsModel.calculateAverage()
        maximumScore = statisticsModel.findMaximumScore()
        minimumScore = statisticsModel.findMinimumScore()
    }
}
