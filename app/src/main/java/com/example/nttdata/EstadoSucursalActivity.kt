package com.example.nttdata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

class EstadoSucursalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EstadoSucursalScreen()
        }
    }
}

// Data model for a workspace status
data class WorkspaceStatus(
    val id: String,
    val xPercent: Float, // 0.0 to 1.0 relative to image width
    val yPercent: Float, // 0.0 to 1.0 relative to image height
    val isAvailable: Boolean,
    val isMeetingRoom: Boolean = false
)

@Composable
fun EstadoSucursalScreen() {
    // Mock data approximating the layout in the image
    // Note: The image is rotated 270 degrees clockwise.
    // Visual Top (v=0) = Logical Right (x=1)
    // Visual Bottom (v=1) = Logical Left (x=0)
    // Visual Left (u=0) = Logical Top (y=0)
    // Visual Right (u=1) = Logical Bottom (y=1)

    // Visual Top Cluster (Logical Right Cluster)
    // Shifted Top (increased X)
    // Shifted Left (decreased Y slightly)
    val topCluster = listOf(
        // Outer Row (Visual Top) -> Logical x=0.93
        WorkspaceStatus("1", 0.93f, 0.13f, false), WorkspaceStatus("2", 0.93f, 0.33f, true),
        WorkspaceStatus("3", 0.93f, 0.53f, true), WorkspaceStatus("4", 0.93f, 0.73f, false),
        // Inner Row (Visual Bottom) -> Logical x=0.79
        WorkspaceStatus("5", 0.79f, 0.13f, true), WorkspaceStatus("6", 0.79f, 0.33f, false),
        WorkspaceStatus("7", 0.79f, 0.53f, false), WorkspaceStatus("8", 0.79f, 0.73f, true)
    )

    // Visual Bottom Cluster (Logical Left Cluster)
    // Shifted Bottom (decreased X)
    // Shifted Right (increased Y more)
    val bottomCluster = listOf(
        // Inner Row (Visual Top) -> Logical x=0.22
        WorkspaceStatus("9", 0.22f, 0.10f, false), WorkspaceStatus("10", 0.22f, 0.30f, true),
        WorkspaceStatus("11", 0.22f, 0.50f, true), WorkspaceStatus("12", 0.22f, 0.70f, false), WorkspaceStatus("13", 0.22f, 0.90f, true),
        // Outer Row (Visual Bottom) -> Logical x=0.07
        WorkspaceStatus("14", 0.07f, 0.10f, false), WorkspaceStatus("15", 0.07f, 0.30f, true),
        WorkspaceStatus("16", 0.07f, 0.50f, false), WorkspaceStatus("17", 0.07f, 0.70f, false), WorkspaceStatus("18", 0.07f, 0.90f, true)
    )

    // Meeting Room (Visual Center Left) -> Logical Top Center (x~0.5, y~0.25)
    val meetingRoom = listOf(WorkspaceStatus("M1", 0.50f, 0.23f, false, isMeetingRoom = true))

    val allWorkspaces = topCluster + bottomCluster + meetingRoom


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

        // Floor Plan Content
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(androidx.compose.foundation.rememberScrollState())
                .horizontalScroll(androidx.compose.foundation.rememberScrollState()),
            contentAlignment = Alignment.Center
        ) {
            // Container for Image + Overlays
            // We rotate this container so markers rotate WITH the image
            Box(
                modifier = Modifier
                    .size(600.dp) // Make it large as requested
                    .rotate(270f) // Rotate the whole group
                    .border(2.dp, Color.Black)
            ) {
                // Plane Image
                Image(
                    painter = painterResource(id = R.drawable.oficina),
                    contentDescription = "Plano Oficina",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )

                // Overlay Status Circles
                // Since parent Box has fixed size (600.dp), we use that for calculations
                Box(modifier = Modifier.fillMaxSize()) {
                    allWorkspaces.forEach { space ->
                        // Calculate position relative to the 600.dp box
                        // percentages from mock data are used directly

                        val color = if (space.isAvailable) Color.Green else Color.Red
                        val size = if (space.isMeetingRoom) 50.dp else 30.dp // Slightly larger markers

                        // We use Align-based positioning or offset.
                        // Since we are inside a Box with fillMaxSize, we can use absolute offsets relative to it.
                        // Note: In Compose, offsets are pixels/dp.
                        // 600.dp is available via BoxWithConstraints or hardcoded since we set it.
                        // We'll use BoxWithConstraints inside to be safe or just rely on alignment.
                        // Simpler: Use relative positioning with BiasAlignment?
                        // xPercent (0..1) -> Bias (-1..1): bias = (percent * 2) - 1

                        Box(
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .offset(
                                    x = 600.dp * space.xPercent - (size / 2),
                                    y = 600.dp * space.yPercent - (size / 2)
                                )
                                .size(size)
                                .clip(CircleShape)
                                .background(color)
                                .border(1.dp, Color.Black, CircleShape)
                        )
                    }
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
fun PreviewEstadoSucursal() {
    EstadoSucursalScreen()
}
