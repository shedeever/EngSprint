package com.example.engsprint.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.engsprint.viewmodel.TestViewModel

/**
 * Activity для экрана тестирования.
 * Использует Jetpack Compose для создания пользовательского интерфейса.
 */
class TestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestScreen()
        }
    }
}

/**
 * Composable функция для отображения теста.
 * Представляет собой интерфейс для прохождения вопросов и выбора ответов.
 */
@Composable
fun TestScreen(testViewModel: TestViewModel = viewModel()) {
    val question = remember { testViewModel.currentQuestion }
    var selectedAnswer by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(question.text, style = MaterialTheme.typography.bodyMedium)
        question.options.forEach { answer ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedAnswer == answer,
                    onClick = { selectedAnswer = answer }
                )
                Text(answer)
            }
        }
        Button(
            onClick = {
                testViewModel.submitAnswer(selectedAnswer)
                selectedAnswer = "" // Сброс выбранного ответа после отправки
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Отправить")
        }
    }
}
