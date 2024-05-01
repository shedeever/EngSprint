package com.example.engsprint.viewmodel

import androidx.lifecycle.ViewModel
import com.example.engsprint.model.UserProfileModel

/**
 * ViewModel для личного кабинета.
 * Управляет данными профиля пользователя, обеспечивая их актуальность и обработку изменений.
 */
class UserProfileViewModel : ViewModel() {
    val userProfileModel = UserProfileModel()
    var name: String = ""
        private set
    var email: String = ""
        private set

    /**
     * Загружает данные профиля пользователя, например, из удаленного сервера или базы данных.
     */
    fun loadProfileData() {
        // Загрузка данных пользователя
        // Обновление переменных name и email
    }

    /**
     * Сохраняет измененные данные профиля пользователя.
     */
    fun saveProfileData(name: String, email: String) {
        userProfileModel.updateProfile(name, email)
        this.name = name
        this.email = email
        // Возможно добавление логики для отображения статуса сохранения
    }
}

