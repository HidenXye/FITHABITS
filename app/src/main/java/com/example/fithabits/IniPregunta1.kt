package com.example.fithabits

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.navigation.NavHostController
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.*

@Composable
fun EscenaCuestionario(navController: NavHostController) {
    val questions = listOf(
        Question(
            title = "¿Cuál es tu nivel de actividad?",
            options = listOf(
                Pair("Sedentario", "\uD83D\uDCBB"),
                Pair("Actividad ligera", "\uD83D\uDC63"),
                Pair("Moderadamente activa", "\uD83C\uDFC3"),
                Pair("Muy activa", "\uD83D\uDE2C") // 😬
            )
        ),
        Question(
            title = "¿Qué te motiva más?",
            options = listOf(
                Pair("Sentir confianza en mí", "\uD83D\uDE04"),
                Pair("Liberar estrés", "\uD83C\uDF88"),
                Pair("Mejorar la salud", "\uD83C\uDFCB"),
                Pair("Aumentar la energía", "\u2600\uFE0F")
            )
        ),
        Question(
            title = "¿Cuál es tu presupuesto?",
            options = listOf(
                Pair("0 - 100$/", "\uD83D\uDE22"),
                Pair("100$ - 500$/", "\uD83D\uDCB0"),
                Pair("500$ - 1000$/", "\uD83D\uDC8E"),
                Pair("+1000$/", "\uD83D\uDCB5") // 💵
            )
        ),
        Question(
            title = "¿Cuál es tu meta?",
            options = listOf(
                Pair("Adelgazar", "\uD83D\uDCB8"),
                Pair("Mejorar Postura", "\uD83E\uDEC1"),
                Pair("Subir de peso", "\uD83C\uDFCB"),
                Pair("Aumentar Músculo", "\uD83D\uDCAA"),
                Pair("Mantener mi peso", "\uD83C\uDF4A")
            )
        )



    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF001629), Color(0xFF1F1F1F))
                )
            )
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(questions.size) { index ->
                QuestionSection(question = questions[index])
            }
            item {
                Button(
                    onClick = { navController.navigate("menu") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2E3A59) ,
                        contentColor = Color.White//MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Text(text = "REGISTRAR")
                }
            }
        }
    }

}

@Composable
fun QuestionSection(question: Question) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = question.title,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                color = Color.White
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        question.options.forEach { (label, emoji) ->
            AnswerOption(label = label, emoji = emoji)
        }
    }
}

@Composable
fun AnswerOption(label: String, emoji: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {  }
            .padding(vertical = 8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = emoji,
                    fontSize = 28.sp
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Medium
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

data class Question(
    val title: String,
    val options: List<Pair<String, String>>
)

