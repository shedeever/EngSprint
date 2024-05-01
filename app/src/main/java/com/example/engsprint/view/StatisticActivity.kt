package com.example.engsprint.view
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.engsprint.viewmodel.StatisticViewModel

/**
 * Activity для отображения статистики курсов.
 * Устанавливает Composable функцию для отображения статистики.
 */
class StatisticsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatisticsScreen()
        }
    }
}

/**
 * Composable функция для отображения статистики по курсам.
 * Показывает средний балл, максимальный и минимальный баллы.
 */
@Composable
fun StatisticsScreen(statisticsViewModel: StatisticViewModel = viewModel()) {
    LaunchedEffect(true) {
        statisticsViewModel.calculateStatistics()
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Средний балл: ${statisticsViewModel.averageScore}")
        Text("Максимальный балл: ${statisticsViewModel.maximumScore}")
        Text("Минимальный балл: ${statisticsViewModel.minimumScore}")
    }
}
