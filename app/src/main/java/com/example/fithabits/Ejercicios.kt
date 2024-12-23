package com.example.fithabits

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Brush

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.fithabits.ui.theme.UserInfo

// Datos del ejercicio
data class WorkoutItem(
    val title: String,
    val description: String,
    val imageRes: Int
)

// Tipos de nivel
enum class WorkoutLevel {
    PRINCIPIANTE, INTERMEDIO, AVANZADO
}

// Pantalla principal que recibe el nivel como argumento
@Composable
fun WorkoutScreen(level: WorkoutLevel) {
    val workouts = when (level) {
        WorkoutLevel.PRINCIPIANTE -> listOf(
            WorkoutItem("ABDOMINALES PRINCIPIANTE", "20 MIN - 16 EJERCICIOS", R.drawable.abdominales_principiante),
            WorkoutItem("PECHO PRINCIPIANTE", "9 MIN - 11 EJERCICIOS", R.drawable.pecho_principiante),
            WorkoutItem("BRAZO PRINCIPIANTE", "17 MIN - 19 EJERCICIOS", R.drawable.brazo_principiante),

            WorkoutItem("PIERNAS PRINCIPIANTE", "26 MIN - 23 EJERCICIOS", R.drawable.piernas_principiante),
            WorkoutItem("HOMBROS Y ESPALDA", "17 MIN - 17 EJERCICIOS", R.drawable.hombros_espalda_principiante)
        )
        WorkoutLevel.INTERMEDIO -> listOf(
            WorkoutItem("ABDOMINALES INTERMEDIO", "20 MIN - 16 EJERCICIOS", R.drawable.abdominales_intermedio),
            WorkoutItem("PECHO INTERMEDIO", "20 MIN - 16 EJERCICIOS", R.drawable.pecho_intermedio),
            WorkoutItem("BRAZO INTERMEDIO", "20 MIN - 16 EJERCICIOS", R.drawable.brazo_intermedio),

            WorkoutItem("PIERNAS INTERMEDIO", "20 MIN - 16 EJERCICIOS", R.drawable.piernas_intermedio),
            WorkoutItem("HOMBROS Y ESPALDA INTERMEDIO", "20 MIN - 16 EJERCICIOS", R.drawable.hombros_espalda_intermedio),
        )
        WorkoutLevel.AVANZADO -> listOf(
            WorkoutItem("ABDOMINALES AVANZADO", "20 MIN - 16 EJERCICIOS", R.drawable.abdominales_avanzado),
            WorkoutItem("PECHO AVANZADO", "20 MIN - 16 EJERCICIOS", R.drawable.pecho_avanzado),
            WorkoutItem("BRAZO AVANZADO", "20 MIN - 16 EJERCICIOS", R.drawable.brazo_avanzado),

            WorkoutItem("PIERNAS AVANZADO", "20 MIN - 16 EJERCICIOS", R.drawable.piernas_avanzado),
            WorkoutItem("HOMBROS Y ESPALDA AVANZADO", "20 MIN - 16 EJERCICIOS", R.drawable.hombros_espalda_avanzado)
        )
    }

    // Mostrar los ejercicios para el nivel seleccionado
    WorkoutColumn(
        level = level.name,
        workouts = workouts
    )
}

// Componente para mostrar una columna de ejercicios
@Composable
fun WorkoutColumn(level: String, workouts: List<WorkoutItem>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF001629), Color(0xFF1F1F1F))
                )
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = level,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(workouts.size) { index ->
                val workout = workouts[index]
                WorkoutCard(workout)
            }
        }
    }
}

// Componente para mostrar los detalles de un ejercicio
@Composable
fun WorkoutCard(workout: WorkoutItem) {
    Card(
        shape = RoundedCornerShape(16.dp), // Bordes redondeados
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2E3A59)), // Fondo oscuro
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp) // Separación entre tarjetas
            //.shadow(elevation = 8.dp, shape = RoundedCornerShape(16.dp)) // Sombra
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // Margen interno
        ) {
            // Imagen del ejercicio
            Image(
                painter = painterResource(id = workout.imageRes),
                contentDescription = workout.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    //.clip(RoundedCornerShape(16.dp)) // Bordes redondeados de la imagen
            )
            Spacer(modifier = Modifier.height(16.dp)) // Espaciado entre imagen y texto
            // Título del ejercicio
            Text(
                text = workout.title,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp) // Espaciado inferior
            )
            // Descripción del ejercicio
            Text(
                text = workout.description,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

// Vista previa para cada nivel
@Preview(showBackground = true)
@Composable
fun PreviewPrincipiante() {
    WorkoutScreen(level = WorkoutLevel.PRINCIPIANTE)
}

//@Preview(showBackground = true)
@Composable
fun PreviewIntermedio() {
    WorkoutScreen(level = WorkoutLevel.INTERMEDIO)
}

//@Preview(showBackground = true)
@Composable
fun PreviewAvanzado() {
    WorkoutScreen(level = WorkoutLevel.AVANZADO)
}
