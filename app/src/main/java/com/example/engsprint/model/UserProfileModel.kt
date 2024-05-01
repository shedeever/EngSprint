package com.example.engsprint.model

/**
 * Модель данных пользователя для личного кабинета.
 * Содержит информацию о пользователе, такую как имя, email и т.д.
 */
class UserProfileModel(var name: String = "", var email: String = "") {
    /**
     * Может включать методы для обновления данных пользователя,
     * например, изменение пароля или обновление контактной информации.
     */
    fun updateProfile(name: String, email: String) {
        this.name = name
        this.email = email
        // Обновление данных в базе данных или через API
    }
}
