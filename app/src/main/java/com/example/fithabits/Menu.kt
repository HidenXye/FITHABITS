package com.example.fithabits

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.fithabits.ui.theme.UserInfo

@Composable
fun SimpleMenuScreen(navController: NavHostController) {
    val menuItems = listOf(
        MenuItem("Ejercicio", Icons.Default.Person, Color(0xFF2E3A59),"ejercicios"),
        MenuItem("Alimentación", Icons.Default.AccountBox, Color(0xFF2E3A59),"alimentacion"),
        MenuItem("Descubre", Icons.Default.Email, Color(0xFF2E3A59),"descubre")
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
        // Caja contenedora del menú
        Card(
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF2E3A59)),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(horizontal = 16.dp, vertical = 32.dp),
            elevation = CardDefaults.elevatedCardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Encabezado con imagen y nombre
                ProfileHeader(
                    name = UserInfo.userName, //"George Samuel",
                    username = UserInfo.userCode//"@george699"
                )

                // Opciones del menú
                menuItems.forEach { item ->
                    MenuItemCard(item,navController)
                }
            }
        }
    }
}

@Composable
fun ProfileHeader(name: String, username: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Placeholder para la foto de perfil
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Gray, shape = RoundedCornerShape(50))

        ){
        Image(
            painter = painterResource(id = R.drawable.persona),
            contentDescription = "userimg",
            modifier = Modifier.size(200.dp),
            contentScale = ContentScale.Fit
        )}
        Text(
            text = name,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Text(
            text = username,
            color = Color.Gray,
            fontSize = 14.sp
        )
    }
}

@Composable
fun MenuItemCard(item: MenuItem,navController: NavHostController) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = item.backgroundColor),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable {
                navController.navigate(item.accion)
            },
        elevation = CardDefaults.elevatedCardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.title,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = item.title,
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

// Modelo de datos
data class MenuItem(
    val title: String,
    val icon: ImageVector,
    val backgroundColor: Color,
    val accion: String
)

@Preview(showBackground = true)
@Composable
fun PreviewSimpleMenuScreen() {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Color(0xFF6200EE),
            onPrimary = Color.White,
            surface = Color(0xFF121212),
            onSurface = Color.White
        )
    ) {
        /*SimpleMenuScreen { selectedMenu ->
            println("Seleccionado: $selectedMenu")
        }*/
    }
}
