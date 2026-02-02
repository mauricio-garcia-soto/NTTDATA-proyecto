package com.example.nttdata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

class CancelarReservaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CancelarReservaScreen()
        }
    }
}

@Composable
fun CancelarReservaScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .windowInsetsPadding(WindowInsets.systemBars)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color(0xFF0072BB))
                .padding( horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "NTT DATA Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .width(10000.dp)
                    .wrapContentWidth(),
                colorFilter =  tint(Color.White)
            )
        }

        // Content
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            
            // Confirmation Box
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color(0xFF0072BB)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Seguro que quiere cancelar la siguiente Reserva?",
                        color = Color(0xFF0072BB),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Reservation Details
            // Using a local data structure or reusing from ReservasActivity if possible.
            // For this view, we'll hardcode the sample data shown in image.
            val sampleReserva = Reserva(
                branch = "Sucursal Castellon:",
                date = "19/12/25",
                time = "10:00-13:00",
                workspace = "5b"
            )
            
            ReservaItem(sampleReserva)

            Spacer(modifier = Modifier.height(32.dp))

            // Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { /* Handle No Cancel */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0072BB)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                        .height(55.dp)
                ) {
                    Text(text = "No cancelar reserva", fontSize = 14.sp)
                }

                Button(
                    onClick = { /* Handle Cancel */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0072BB)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                        .height(55.dp)
                ) {
                    Text(text = "Cancelar reserva", fontSize = 14.sp)
                }
            }
        }

        // Footer Navigation
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color(0xFF0072BB)),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "Reservar",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "Gestionar",
                tint = Color.White.copy(alpha = 0.6f),
                modifier = Modifier.size(30.dp)
            )
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Sucursales",
                tint = Color.White.copy(alpha = 0.6f),
                modifier = Modifier.size(30.dp)
            )
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Estado",
                tint = Color.Red,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

// Reuse ReservaItem from ReservasActivity if accessible, otherwise redefine here for isolation if user wants "classe canelarReserva" to be standalone. 
// Given the context, I will redefine a specific version here similar to the one in ReservasActivity but simpler or matching exactly if needed.
// Actually, I'll rely on the one in ReservasActivity.kt if it's public.
// However, to be safe and avoid compilation errors if imports are tricky or if `ReservaItem` was not top-level public/reused correctly, I'll define a local private one or just use `ReservaItem` since they are in the same package.
// I will assume `Reserva` class is available from `ReservasActivity.kt` package level.

@Preview(showBackground = true)
@Composable
fun PreviewCancelarReserva() {
    CancelarReservaScreen()
}
