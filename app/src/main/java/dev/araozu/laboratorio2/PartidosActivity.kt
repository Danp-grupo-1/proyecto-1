package dev.araozu.laboratorio2

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.araozu.laboratorio2.model.Partidos


var listaPartidos = Partidos.values()

//Cambiar datos partidoss

@Composable
fun BotonPartido(partido: Partidos, navController: NavController) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(onClick = {
            navController.navigate(
                route = Destinations.CandidatosPartidoScreen.createRoute(
                    partido.name
                )
            )
        }) {
            Text(
                text = partido.toString(),
                style = TextStyle(
                    fontSize = 20.sp, fontWeight = FontWeight.Light, fontStyle = FontStyle.Italic
                )
            )
        }
    }
}

@Composable
fun ListPartidos(navController: NavController) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Partidos de Arequipa",
                style = TextStyle(
                    color = Color.Blue,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
            )
        }
        items(listaPartidos) {
            BotonPartido(it, navController)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}