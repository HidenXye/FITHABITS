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
 /*data class WorkoutItem(
    val title: String,
    val description: String,
    val imageRes: Int
)*/

// Tipos de nivel
/*enum class WorkoutLevel {
    PRINCIPIANTE, INTERMEDIO, AVANZADO
}*/

// Pantalla principal que recibe el nivel como argumento
@Composable
fun AlimentacionEscena(level: WorkoutLevel) {
    val workouts = when (level) {
        WorkoutLevel.PRINCIPIANTE -> listOf(
            WorkoutItem("POLLO CON VERDURAS", "20 MIN - 16 EJERCICIOS", R.drawable.pollo_con_verduras),
            WorkoutItem("AVENA CON FRUTAS", "9 MIN - 11 EJERCICIOS", R.drawable.avena_con_frutas),
            WorkoutItem("JUGO DE FRUTOS VERDES", "17 MIN - 19 EJERCICIOS", R.drawable.jugo_de_frutos_verdes),

        )
        WorkoutLevel.INTERMEDIO -> listOf(
            WorkoutItem("SALMÓN A LA PARRILLA", "20 MIN - 16 EJERCICIOS", R.drawable.salmon_a_la_parrilla),
            WorkoutItem("OMELETTE CON ESPINACAS Y CHAMPIÑONES", "20 MIN - 16 EJERCICIOS", R.drawable.omelette_con_espinacas),
            WorkoutItem("POLLO AL HORNO CON CAMOTE Y BROCOLI", "20 MIN - 16 EJERCICIOS", R.drawable.pollo_al_horno),

        )
        WorkoutLevel.AVANZADO -> listOf(
            WorkoutItem("TOFU CON VERDURAS AL VAPOR", "20 MIN - 16 EJERCICIOS", R.drawable.tofu_con_verduras),
            WorkoutItem("ENSALADA DETOX CON KALE, REMOLACHA Y NUECES", "20 MIN - 16 EJERCICIOS", R.drawable.ensalada_detox),
            WorkoutItem("MERLUZA AL VAPOR CON ESPÁRRAGOS Y QUINOA", "20 MIN - 16 EJERCICIOS", R.drawable.merluza_al_vapor),
        )
    }

    // Mostrar los ejercicios para el nivel seleccionado
    WorkoutColumn(
        level = level.name,
        workouts = workouts
    )
}


