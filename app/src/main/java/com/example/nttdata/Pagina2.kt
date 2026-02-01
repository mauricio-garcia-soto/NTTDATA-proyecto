package com.example.nttdata

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
class Pagina2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IPhone16ProMax3()
        }
    }
}
@Composable
fun IPhone16ProMax3() {
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(vertical = 193.dp),
        ) {
            // Imagen
            Image(
                painter = rememberAsyncImagePainter(
                    "https://storage.googleapis.com/tagjs-prod.appspot.com/v1/81XQccjZHz/c0t5ztzh_expires_30_days.png"
                ),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .padding(bottom = 109.dp)
            )

            // Botones
            val buttonModifier = Modifier
                .padding(bottom = 64.dp, start = 23.dp, end = 23.dp)
                .clip(RoundedCornerShape(15.dp))
                .fillMaxWidth()
                .background(
                    color = Color(0xFF0072BB),
                    shape = RoundedCornerShape(15.dp)
                )

            val textStyle: @Composable (String) -> Unit = { text ->
                Text(
                    text = text,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            OutlinedButton(
                onClick = {
                    val intent = Intent(context, ReservationActivity::class.java)
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent
                ),
                border = BorderStroke(0.dp, Color.Transparent),
                modifier = buttonModifier
            ) { textStyle("Reservar Espacio de trabajo") }

            OutlinedButton(
                onClick = { println("Pressed!") },
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                border = BorderStroke(0.dp, Color.Transparent),
                modifier = buttonModifier
            ) { textStyle("Gestionar reservas") }

            OutlinedButton(
                onClick = { println("Pressed!") },
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                border = BorderStroke(0.dp, Color.Transparent),
                modifier = buttonModifier
            ) { textStyle("Cambiar Sucursal") }

            OutlinedButton(
                onClick = { println("Pressed!") },
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
                border = BorderStroke(0.dp, Color.Transparent),
                modifier = buttonModifier.padding(bottom = 0.dp)
            ) { textStyle("Consultar Estado Sucursal") }
        }
    }
}
@Preview
@Composable
fun preview(){
    IPhone16ProMax3()
}

