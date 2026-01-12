package com.example.nttdata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nttdata.ui.theme.NTTDATATheme

import androidx.compose.runtime.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.*
import androidx.compose.material.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.layout.*
import com.skydoves.landscapist.*
import com.skydoves.landscapist.coil3.*
//Cambioooooooooooooossssssssssss
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IPhone16ProMax1()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IPhone16ProMax1()
}

@Composable
fun IPhone16ProMax1() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = Color(0xFFFFFFFF),
            )
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    color = Color(0xFFFFFFFF),
                )
                .padding(top = 192.dp,)
                .verticalScroll(rememberScrollState())
        ){
            CoilImage(
                imageModel = {"https://storage.googleapis.com/tagjs-prod.appspot.com/v1/81XQccjZHz/6jwa1p2b_expires_30_days.png"},
                imageOptions = ImageOptions(contentScale = ContentScale.Crop),
                modifier = Modifier
                    .padding(bottom = 99.dp,)
                    .height(80.dp)
                    .fillMaxWidth()
            )
            Column(
                modifier = Modifier
                    .padding(bottom = 12.dp,start = 23.dp,end = 23.dp,)
                    .fillMaxWidth()
            ){
                Text("Id",
                    color = Color(0xFF0072BB),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 8.dp,)
                )
                Column(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFF0072BB),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clip(shape = RoundedCornerShape(10.dp))
                        .height(57.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFF0072BB),
                            shape = RoundedCornerShape(10.dp)
                        )
                ){
                }
            }
            Column(
                modifier = Modifier
                    .padding(bottom = 28.dp,start = 21.dp,end = 21.dp,)
                    .fillMaxWidth()
                    .padding(end = 2.dp,)
            ){
                Text("Contraseña",
                    color = Color(0xFF0072BB),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 2.dp,)
                )
                Column(
                    modifier = Modifier
                        .padding(bottom = 2.dp,start = 2.dp,)
                        .border(
                            width = 1.dp,
                            color = Color(0xFF000000),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clip(shape = RoundedCornerShape(10.dp))
                        .height(47.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFF0072BB),
                            shape = RoundedCornerShape(10.dp)
                        )
                ){
                }
                Text("Olvido la contraseña",
                    color = Color(0xFF000000),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            OutlinedButton(
                onClick = { println("Pressed!") },
                border = BorderStroke(0.dp, Color.Transparent),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent
                ),
                contentPadding = PaddingValues(),
                modifier = Modifier
                    .padding(bottom = 48.dp, start = 23.dp, end = 23.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFF0072BB),
                        shape = RoundedCornerShape(15.dp)
                    )
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(vertical = 15.dp,)
                ){
                    Text("Iniciar sesion",
                        color = Color(0xFFFFFFFF),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}