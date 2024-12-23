package com.example.fithabits

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
fun HealthReportScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEAF2F8)) // Fondo celeste claro
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        // Título principal
        Text(
            text = "INFORME",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Sección: Resumen general
        SummarySection()

        Spacer(modifier = Modifier.height(16.dp))

        // Sección: Historial
        HistorySection()

        Spacer(modifier = Modifier.height(16.dp))

        // Sección: Peso
        WeightSection()

        Spacer(modifier = Modifier.height(16.dp))

        // Sección: IMC
        BMISection()
    }
}

@Composable
fun SummarySection() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        SummaryItem(icon = "🥇", label = "ejercicio", value = "0")
        SummaryItem(icon = "🔥", label = "kcal", value = "0")
        SummaryItem(icon = "⏱️", label = "Minuto", value = "0")
    }
}

@Composable
fun SummaryItem(icon: String, label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = icon, fontSize = 24.sp)
        Text(text = value, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = label, fontSize = 14.sp, textAlign = TextAlign.Center)
    }
}

@Composable
fun HistorySection() {
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
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Historial", fontWeight = FontWeight.Bold)
                Text(
                    text = "Todos los registros",
                    color = Color(0xFF0066CC), // Azul
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Días de la semana
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("Lun", "Mar", "Mié", "Jue", "Vie").forEachIndexed { index, day ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = day, fontSize = 14.sp)
                        if (index == 2) {
                            // Miércoles
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .background(Color.Black, shape = CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "5", color = Color.White, fontWeight = FontWeight.Bold)
                            }
                        } else {
                            Text(text = (3 + index).toString(), fontSize = 14.sp)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "0 Días de racha",
                fontSize = 12.sp,
                color = Color.Gray
            )
            Text(
                text = "Récord personal: 0 días",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun WeightSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Peso", fontWeight = FontWeight.Bold)
                Text(
                    text = "Registro",
                    color = Color(0xFF4CAF50), // Verde
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Actual", fontSize = 12.sp, color = Color.Gray)
            Text(text = "65.9 kg", fontSize = 28.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Peso máx: 65.9   Peso mín: 65.9",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun BMISection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "IMC", fontWeight = FontWeight.Bold)
                Text(
                    text = "Cambiar",
                    color = Color(0xFF4CAF50), // Verde
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "24.2", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Text(
                text = "Peso saludable",
                fontSize = 12.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Altura: 165 cm",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewHealthReportScreen() {
    HealthReportScreen()
}