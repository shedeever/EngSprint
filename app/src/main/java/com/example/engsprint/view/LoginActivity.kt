package com.example.engsprint.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.engsprint.viewmodel.LoginViewModel

/**
 * Activity, служащая точкой входа для экрана логина.
 * Устанавливает контент экрана, используя Jetpack Compose.
 */
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

/**
 * Composable функция для отображения интерфейса экрана логина.
 * Предоставляет текстовые поля для ввода имени пользователя и пароля, кнопку входа и отображает сообщения.
 */
@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Имя пользователя") }
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Пароль") }
        )
        Button(
            onClick = { loginViewModel.login(username, password) },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Войти")
        }
        Text(loginViewModel.message)
    }
}
