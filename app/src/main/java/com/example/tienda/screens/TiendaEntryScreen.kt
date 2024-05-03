package com.example.tienda.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.tienda.Arranque
import com.example.tienda.database.TiendaEntidad
import com.example.tienda.navigation.AppScreens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TiendaEntryScreen (navController: NavController){
    var nombre = remember { mutableStateOf("") }
    var descripcion = remember { mutableStateOf("") }
    var visitas = remember { mutableStateOf("") }
    var url = remember { mutableStateOf("") }


    val buttonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Transparent,
        contentColor = Color.Black,
        disabledContainerColor = Color.Transparent,
        disabledContentColor = Color.Black
    )

    val db = Arranque.room

    val scope = rememberCoroutineScope()

    Card(modifier = Modifier
        .fillMaxWidth()) {
        Row(modifier = Modifier.background(color = Color.LightGray).fillMaxWidth()
            .padding(horizontal = 80.dp)) {
            Text(text = "Ingreso de datos", fontWeight = FontWeight.SemiBold, fontStyle = FontStyle.Italic)

        }

    }
    Column(
        modifier = Modifier
            .padding(horizontal = 50.dp, vertical = 0.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp, vertical = 30.dp)
                .zIndex(4f),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(Modifier.padding(7.dp).background(color = Color.LightGray).fillMaxWidth()) {
                Text(text = "Cedeño Vera Helion Maximiliano", Modifier.padding(4.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Tienda", Modifier.padding(4.dp))
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Septimo B", Modifier.padding(4.dp))
            }
        }
        TextField(
            value = nombre.value,
            singleLine = true,
            onValueChange = { nombre.value = it },
            label = { Text("Nombre", color = Color.Black) },
            modifier = Modifier
                .padding(vertical = 5.dp)
                .border(8.dp, Color.Gray, RoundedCornerShape(5.dp)),
        )

        TextField(
            value = descripcion.value,
            singleLine = true,
            onValueChange = { descripcion.value = it },
            label = { Text("Descripcion", color = Color.Black) },
            modifier = Modifier
                .padding(vertical = 5.dp)
                .border(8.dp, Color.Gray, RoundedCornerShape(5.dp)),
        )

        TextField(
            value = visitas.value,
            onValueChange = { visitas.value = it },
            label = { Text("Visitas") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .padding(vertical = 5.dp)
                .background(Color.White)
                .border(8.dp, Color.Gray, RoundedCornerShape(5.dp)),
        )

        TextField(
            value = url.value,
            singleLine = true,
            onValueChange = { url.value = it },
            label = { Text("Url", color = Color.Black) },
            modifier = Modifier
                .padding(vertical = 5.dp)
                .border(8.dp, Color.Gray, RoundedCornerShape(5.dp)),
        )
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Button(
                onClick = {
                    if (nombre.value.isBlank() || descripcion.value.isBlank() || visitas.value.isBlank() ||
                        url.value.isBlank()
                    ) {

                    } else {
                        val tienda = TiendaEntidad(
                            Nombre = nombre.value,
                            Descripcion = descripcion.value,
                            Visitas = visitas.value.toInt(),
                            Url = url.value
                        )
                        scope.launch {
                            withContext(Dispatchers.Main) {
                                db.getTiendaDao().insert(tienda)
                                nombre.value = ""
                                descripcion.value = ""
                                visitas.value = ""
                                url.value = ""
                            }
                        }

                    }

                },
                modifier = Modifier.padding(vertical = 30.dp, horizontal = 0.dp),
                border = BorderStroke(3.dp, Color.Black)
            ) {
                Text("Guardar tienda")
            }
        }
        Row(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .fillMaxHeight()) {
            Button(
                onClick = {
                    navController.navigate(route = AppScreens.TiendaRegistros.route)
                },
                colors = buttonColors,
                modifier = Modifier.align(Alignment.Bottom),
                border = BorderStroke(5.dp, Color.Gray)
            ) {
                Text("Ver tiendas guardadas", fontSize = 16.sp)
            }

        }


    }





}