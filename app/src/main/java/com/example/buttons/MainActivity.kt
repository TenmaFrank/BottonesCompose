package com.example.buttons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buttons.ui.theme.ButtonsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val darkmode = remember {
                mutableStateOf(false)
            }
            ButtonsTheme(
                darkTheme = darkmode.value
            ) {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Content(darkmode)
                }
            }
        }
    }
}

@Composable
fun Content(darkmode: MutableState<Boolean>) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally) {
        BotonNormal()
        Space()
        BotonNormal2()
        Space()
        BotonTexto()
        Space()
        BotonOutline()
        Space()
        BotonIcono()
        Space()
        BotonSwitch()
        Space()
        DarkModeButton(darkmode = darkmode)
        Space()
        FloatingAction()
    }
}

@Composable
fun BotonNormal(){
    Button(onClick = { /*TODO*/ }, enabled = false) {
        Text(text = "mi boton", fontSize = 30.sp)
    }
}
@Composable
fun BotonTexto(){
    TextButton(onClick = { /*TODO*/ }) {
        Text(text = "mi boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonOutline(){
    OutlinedButton(onClick = { /*TODO*/ },
    border = BorderStroke(5.dp, androidx.compose.ui.graphics.Color.Blue)){
        Text(text = "mi boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonNormal2(){
    Button(onClick = { /*TODO*/ }, enabled = true, colors = ButtonDefaults.buttonColors(
        backgroundColor  = androidx.compose.ui.graphics.Color.Red
    )) {
        Text(text = "mi boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonIcono(){
    IconButton(onClick = { /*TODO*/ }) { 
        Icon(Icons.Filled.Home, contentDescription = "Icono", 
            tint = Color.Red, modifier = Modifier.size(50.dp))
    }
}

@Composable
fun BotonSwitch(){
    var switeched by remember { mutableStateOf(false) }
    Switch(checked = switeched, onCheckedChange = {switeched = it},
    colors = SwitchDefaults.colors(
        checkedThumbColor = Color.Red,
        checkedTrackColor = Color.Green,
        uncheckedThumbColor = Color.Blue,
        uncheckedTrackColor = Color.Magenta
    ))
}

@Composable
fun Space(){
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun DarkModeButton(darkmode: MutableState<Boolean>){
    Button(onClick = { darkmode.value = !darkmode.value}) {
        Icon(imageVector = Icons.Default.AddCircle, contentDescription = "DarkMode",)
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "DarkMode", fontSize = 30.sp)
    }
}

@Composable
fun FloatingAction(){
    FloatingActionButton(
        onClick = { /*TODO*/ }
    ) {
        Icon( Icons.Filled.Add, contentDescription ="",
        modifier = Modifier.size(30.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val darkmode = remember {
        mutableStateOf(false)
    }
    ButtonsTheme { 
        Content (darkmode = darkmode)
    }
}