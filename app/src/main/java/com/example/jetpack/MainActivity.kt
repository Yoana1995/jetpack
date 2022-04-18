package com.example.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.jetpack.ui.theme.JetpackTheme

private val messages: List<MyMessage> = listOf(
    MyMessage("Hola número 1", "Este el mensaje número 1"),
    MyMessage("Hola número 2", "Este el mensaje número 2"),
    MyMessage("Hola número 3", "Este el mensaje número 3"),
    MyMessage("Hola número 4", "Este el mensaje número 4"),
    MyMessage("Hola número 5", "Este el mensaje número 5"),
    MyMessage("Hola número 6", "Este el mensaje número 6"),
    MyMessage("Hola número 7", "Este el mensaje número 7"),
    MyMessage("Hola número 8", "Este el mensaje número 8"),
    MyMessage("Hola número 9", "Este el mensaje número 9"),
    MyMessage("Hola número 10", "Este el mensaje número 10"),
    MyMessage("Hola número 10", "Este el mensaje número 11"),
    MyMessage("Hola número 10", "Este el mensaje número 12"),
    MyMessage("Hola número 10", "Este el mensaje número 13"),
    MyMessage("Hola número 10", "Este el mensaje número 14"),
    MyMessage("Hola número 10", "Este el mensaje número 15")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTheme() {
                MyMessages(messages)
            }
        }
    }
}
    data class MyMessage(val titulo: String, val cuerpo: String)
    @Composable
    fun MyMessages(messages: List<MyMessage>){
        LazyColumn(){
            items(messages){
                message -> componente(message)
            }
        }
    }
    @Composable
    fun componente(message: MyMessage){
        Row(modifier = Modifier
            .background(color = White)
            .padding(8.dp)){
         imagen()
         MyTexts(message)
        }
    }

    @Composable
    fun imagen(){
        Image(
            painterResource(R.drawable.ic_launcher_foreground),
        "Prueba",
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colors.primary)
                .size(64.dp)
        )
    }

    @Composable
    fun MyTexts(message: MyMessage){
        Column() {
            MyText(message.titulo,
                MaterialTheme.colors.primary,
                MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.height(16.dp))
            MyText(message.cuerpo,
                MaterialTheme.colors.primarySurface,
                MaterialTheme.typography.subtitle2
            )
        }
    }

    @Composable
    fun MyText(text:String, color: Color, style: androidx.compose.ui.text.TextStyle){
        Text(text, color = color,style = style)
    }
    @Preview(showSystemUi = true)
    @Composable
    fun proyecto(){
        JetpackTheme {
            MyMessages(messages)
        }
    }

