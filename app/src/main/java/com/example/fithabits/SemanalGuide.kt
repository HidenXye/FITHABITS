package com.example.fithabits

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeWorkoutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEAF2F8)) // Fondo celeste claro
            .padding(16.dp)
    ) {
        // Título principal
        Text(
            text = "EJERCICIOS EN CASA",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Sección: Objetivo semanal
        WeeklyGoalSection()

        Spacer(modifier = Modifier.height(16.dp))

        // Sección: Desafíos
        ChallengeSection()
    }
}

@Composable
fun WeeklyGoalSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Objetivo semanal",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "0/4",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Días de la semana
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf(3, 4, 5, 6, 7, 8, 9).forEach { day ->
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                color = if (day == 5) Color.Black else Color.Transparent,
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = day.toString(),
                            fontSize = 16.sp,
                            color = if (day == 5) Color.White else Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ChallengeSection() {
    Column {
        Text(
            text = "DESAFÍO 7X4",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        // Desafíos
        ChallengeCard(
            title = "TODO EL CUERPO DESAFÍO",
            description = "Inicia tu viaje para tonificar el cuerpo y trabajar todos los grupos musculares. ¡Construye tu cuerpo soñado en 4 semanas!",
            color = Color(0xFF0017FF) // Azul intenso
        )

        Spacer(modifier = Modifier.height(16.dp))

        ChallengeCard(
            title = "TREN INFERIOR DESAFÍO",
            description = "En solo 4 semanas, fortalece tus piernas y aumenta la fuerza de la parte inferior del cuerpo y mejora tu fuerza general.",
            color = Color(0xFF00C8FF) // Azul celeste
        )
    }
}

@Composable
fun ChallengeCard(title: String, description: String, color: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = color),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Acción de inicio */ },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(text = "INICIO", color = color)
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun PreviewHomeWorkoutScreen() {
    HomeWorkoutScreen()
}
