package com.example.tienda.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.tienda.Arranque
import com.example.tienda.database.TiendaEntidad
import com.example.tienda.navigation.AppScreens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@Composable
fun TiendaRegistrosScreen(navController: NavController){

    val tiendas = remember { mutableStateListOf<TiendaEntidad>() }
    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            val loadedTiendas = Arranque.room.getTiendaDao().getAllTiendas()
            tiendas.addAll(loadedTiendas)
        }
    }

    if (tiendas.isNotEmpty()) {
        Column {
            Card(modifier = Modifier
                .fillMaxWidth()) {
                Row(modifier = Modifier.background(color = Color.LightGray).fillMaxWidth()
                    .padding(horizontal = 80.dp)) {
                    Text(text = "Registro de datos", fontWeight = FontWeight.SemiBold, fontStyle = FontStyle.Italic)
                }
            }
            tiendas.forEach { tienda ->
                TiendaData(tienda)
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    } else {
        Text(text = "No hay tiendas registradas")
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TiendaData(tienda: TiendaEntidad) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(20.dp)
            .zIndex(4f),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(Modifier.padding(20.dp)) {
            Text(text = "ID: ${tienda.id}")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Nombre: ${tienda.Nombre}")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Descripción: ${tienda.Descripcion}")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Visitas: ${tienda.Visitas}")
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Url: ${tienda.Url}")
        }
    }
}
