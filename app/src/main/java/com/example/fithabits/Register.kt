package com.example.fithabits

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavHostController
import com.example.fithabits.data.RegistroRequest
import com.example.fithabits.data.RetrofitServiceFactory
import com.example.fithabits.ui.theme.UserInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun RegisterScreen(navController: NavHostController) {

    val username = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }
    val termsAccepted = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD3E3E5)), // Color de fondo
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White, RoundedCornerShape(16.dp))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título
            Text(
                text = "Regístrate",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Campos de texto
            TextField(
                value = username.value,
                onValueChange = { username.value = it },
                placeholder = { Text("Nombre de usuario") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            TextField(
                value = email.value,
                onValueChange = { email.value = it },
                placeholder = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                placeholder = { Text("Contraseña") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            TextField(
                value = confirmPassword.value,
                onValueChange = { confirmPassword.value = it },
                placeholder = { Text("Confirmar contraseña") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Checkbox para términos y condiciones
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Checkbox(
                    checked = termsAccepted.value,
                    onCheckedChange = { termsAccepted.value = it }
                )
                Text(text = "Términos y Condiciones")
            }

            // Botones
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        if(password.value != confirmPassword.value){
                            return@Button
                        }
                        val service = RetrofitServiceFactory.makeRetrofitService()
                        val request = RegistroRequest(username.value, password.value,email.value)
                        kotlinx.coroutines.GlobalScope.launch(Dispatchers.IO) {
                            try {
                                val response =
                                    service.Registrar(request)
                                UserInfo.userName = response.Usuario

                                withContext(Dispatchers.Main) {
                                    navController.navigate("cuestionario")
                                }
                            } catch (e: Exception) {
                            }
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                        .background(Color.White)
                ) {
                    Text(text = "REGISTRAR", color = Color.White)
                }
                Button(
                    onClick = { navController.navigate("home") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                        .background(Color.White)
                ) {
                    Text(text = "CANCELAR", color = Color.White)
                }
            }
        }
    }
}
