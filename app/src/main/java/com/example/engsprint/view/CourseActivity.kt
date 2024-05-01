package com.example.engsprint.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.engsprint.model.Course
import com.example.engsprint.viewmodel.CourseViewModel

/**
 * Activity, служащая точкой входа для экрана выбора курса.
 * Использует Jetpack Compose для построения UI.
 */
class CourseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseSelectionScreen()
        }
    }
}

/**
 * Composable функция для отображения списка курсов.
 * Пользователи могут просмотреть и выбрать курс из предложенного списка.
 */
@Composable
fun CourseSelectionScreen(courseViewModel: CourseViewModel = viewModel()) {
    val courses = courseViewModel.getCourses()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Выберите курс", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(courses) { course ->
                CourseItem(course)
            }
        }
    }
}

/**
 * Composable функция для отображения элемента списка курса.
 */
@Composable
fun CourseItem(course: Course) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(course.name, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(course.description)
        }
    }
}
