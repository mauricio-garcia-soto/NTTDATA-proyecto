package com.example.nttdata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

class ConfirmarCancelacionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConfirmarCancelacionScreen()
        }
    }
}

@Composable
fun ConfirmarCancelacionScreen() {
    // Sample Data - assuming one was removed (e.g., the 10:00-13:00 one)
    val reservations = listOf(
        Reserva("Sucursal Castellón:", "19/12/25", "17:00-21:00", "5b"),
        Reserva("Sucursal Castellón:", "20/12/25", "08:00-15:00", "5b")
    )

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
                .padding(horizontal = 16.dp, vertical = 24.dp)
        ) {
            
            // Success Message Box
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color(0xFF0072BB)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Reserva cancelada correctamente",
                        color = Color(0xFF0072BB),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Success",
                        tint = Color(0xFF2E7D32), // Green color
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            // Title
            Text(
                text = "Tus Reservas:",
                color = Color(0xFF0072BB),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Updated List
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(reservations) { reservation ->
                    ReservaItem(reservation)
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

@Preview(showBackground = true)
@Composable
fun PreviewConfirmarCancelacion() {
    ConfirmarCancelacionScreen()
}
