package com.example.challengersemana2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challengersemana2.ui.theme.ChallengerSemana2Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChallengerSemana2Theme {

                var txtUsu by remember { mutableStateOf("") }
                var txtPas by remember { mutableStateOf("") }
                var errorMessage by remember { mutableStateOf("") }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    TopAppBar(
                        title = { Text(text = "UPC MOVIL") },
                        navigationIcon = {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null)
                        }
                    )

                    Image(
                        painter = painterResource(id = R.drawable.login),
                        contentDescription = null,
                        modifier = Modifier.height(200.dp)
                    )

                    Text(text = "LOGIN STUDENT",
                        fontSize = 32.sp,
                        color = Color.Blue
                    )

                    OutlinedTextField(
                        value = txtUsu,
                        modifier = Modifier.padding(vertical = 15.dp),
                        label = { Text(text = "Ingrese usuario") },
                        onValueChange = { txtUsu = it }
                    )

                    OutlinedTextField(
                        value = txtPas,
                        modifier = Modifier.padding(vertical = 15.dp),
                        label = { Text(text = "Ingrese contraseña") },
                        onValueChange = { txtPas = it },
                        visualTransformation = PasswordVisualTransformation()
                    )

                    Button(
                        colors = ButtonDefaults.buttonColors(
                            Color(242, 41, 195, 250)
                        ),
                        modifier = Modifier.padding(20.dp).width(250.dp),
                        onClick = {
                            if (txtUsu == "Jose Perez" && txtPas == "UPC123") {
                                val navigate = Intent(this@MainActivity, MainActivity2::class.java)
                                navigate.putExtra("username", txtUsu)
                                startActivity(navigate)
                            } else {
                                errorMessage = "Usuario y/o password incorrecto"
                                Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
                            }
                        }
                    ) {
                        Text(
                            text = "Iniciar Sesión",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }

                    if (errorMessage.isNotEmpty()) {
                        Text(
                            text = errorMessage,
                            color = Color.Red,
                            modifier = Modifier.padding(top = 10.dp)
                        )
                    }
                }
            }
        }
    }
}