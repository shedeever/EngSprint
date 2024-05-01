package com.example.engsprint.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.engsprint.viewmodel.UserProfileViewModel

/**
 * Activity для личного кабинета пользователя.
 * Использует Jetpack Compose для декларативного создания пользовательского интерфейса.
 */
class UserProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserProfileScreen()
        }
    }
}

/**
 * Composable функция для отображения и редактирования данных профиля пользователя.
 * Позволяет пользователю вводить и сохранять изменения в его персональных данных.
 */
@Composable
fun UserProfileScreen(userProfileViewModel: UserProfileViewModel = viewModel()) {
    var name by remember { mutableStateOf(userProfileViewModel.name) }
    var email by remember { mutableStateOf(userProfileViewModel.email) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Имя") }
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )
        Button(
            onClick = { userProfileViewModel.saveProfileData(name, email) },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Сохранить изменения")
        }
    }
}
