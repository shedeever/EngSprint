package com.example.engsprint.viewmodel

import androidx.lifecycle.ViewModel
import com.example.engsprint.model.Course
import com.example.engsprint.model.CourseModel

/**
 * ViewModel для экрана выбора курса.
 * Управляет логикой выбора курса и взаимодействует с моделью данных курсов.
 */
class CourseViewModel : ViewModel() {
    private val courseModel = CourseModel()

    init {
        courseModel.loadCourses()
    }

    /**
     * Возвращает список курсов для отображения.
     */
    fun getCourses(): List<Course> {
        return courseModel.courses
    }
}
