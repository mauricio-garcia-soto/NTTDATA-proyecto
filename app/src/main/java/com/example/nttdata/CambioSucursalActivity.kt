package com.example.nttdata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

class CambioSucursalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CambioSucursalScreen()
        }
    }
}

@Composable
fun CambioSucursalScreen() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Seleccione una sucursal") }
    val options = listOf("Sucursal Castellón", "Sucursal Valencia", "Sucursal Madrid", "Sucursal Barcelona")

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
                .padding(24.dp)
        ) {
            
            // Sucursal Actual
            Text(
                text = "Sucursal actual",
                color = Color(0xFF0072BB),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            Surface(
                color = Color(0xFFE3F2FD),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
            ) {
                Text(
                    text = "Castellon de la plana (UJI)",
                    modifier = Modifier.padding(12.dp),
                    fontWeight = FontWeight.SemiBold
                )
            }

            // Consultar Estado Button
            Button(
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0072BB)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(text = "Consultar Estado", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Cambiar Sucursal Dropdown
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = { expanded = true },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0072BB)),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(0.dp), // Custom padding for layout
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Cambiar sucursal", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        }
                        
                        // Divider line simulation
                        Box(
                            modifier = Modifier
                                .width(1.dp)
                                .fillMaxHeight()
                                .background(Color.White.copy(alpha = 0.5f))
                        )

                        Box(
                            modifier = Modifier
                                .width(48.dp)
                                .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = "Expand",
                                tint = Color.White,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .fillMaxWidth(0.9f) // Adjust width to match button approximately
                        .background(Color.White)
                ) {
                    options.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(text = option) },
                            onClick = {
                                selectedOption = option
                                expanded = false
                            }
                        )
                    }
                }
            }
            
            // Spacer to push Confirmar to bottom area (visually)
            Spacer(modifier = Modifier.weight(1f))

            // Confirmar Button
            Button(
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0072BB)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Confirmar", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            
            Spacer(modifier = Modifier.height(24.dp))
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
fun PreviewCambioSucursal() {
    CambioSucursalScreen()
}
