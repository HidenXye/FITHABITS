package com.example.fithabits


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.fithabits.ui.theme.UserInfo

@Composable
fun AlimentacionEscena() {
    val workouts = when (UserInfo.currentNivel) {
    //when (UserInfo.currentNivel) {
        1 -> listOf(
            WorkoutItem("POLLO CON VERDURAS", "20 MIN - 16 EJERCICIOS", R.drawable.pollo_con_verduras),
            WorkoutItem("AVENA CON FRUTAS", "9 MIN - 11 EJERCICIOS", R.drawable.avena_con_frutas),
            WorkoutItem("JUGO DE FRUTOS VERDES", "17 MIN - 19 EJERCICIOS", R.drawable.jugo_de_frutos_verdes),

        )
        2 -> listOf(
            WorkoutItem("SALMÓN A LA PARRILLA", "20 MIN - 16 EJERCICIOS", R.drawable.salmon_a_la_parrilla),
            WorkoutItem("OMELETTE CON ESPINACAS Y CHAMPIÑONES", "20 MIN - 16 EJERCICIOS", R.drawable.omelette_con_espinacas),
            WorkoutItem("POLLO AL HORNO CON CAMOTE Y BROCOLI", "20 MIN - 16 EJERCICIOS", R.drawable.pollo_al_horno),

        )
        3 -> listOf(
            WorkoutItem("TOFU CON VERDURAS AL VAPOR", "20 MIN - 16 EJERCICIOS", R.drawable.tofu_con_verduras),
            WorkoutItem("ENSALADA DETOX CON KALE, REMOLACHA Y NUECES", "20 MIN - 16 EJERCICIOS", R.drawable.ensalada_detox),
            WorkoutItem("MERLUZA AL VAPOR CON ESPÁRRAGOS Y QUINOA", "20 MIN - 16 EJERCICIOS", R.drawable.merluza_al_vapor),
        )
        else ->listOf(
            WorkoutItem("POLLO CON VERDURAS", "20 MIN - 16 EJERCICIOS", R.drawable.pollo_con_verduras),
            WorkoutItem("AVENA CON FRUTAS", "9 MIN - 11 EJERCICIOS", R.drawable.avena_con_frutas),
            WorkoutItem("JUGO DE FRUTOS VERDES", "17 MIN - 19 EJERCICIOS", R.drawable.jugo_de_frutos_verdes),
            )
    }

    WorkoutColumn(
        level = UserInfo.currentNivel,
        workouts = workouts
    )
}


