package br.com.fiap.startupfiap.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CadastroScreen(navController: NavController) {
    var name by remember() {
        mutableStateOf("")
    }

    var email by remember() {
        mutableStateOf("")
    }

    var password by remember() {
        mutableStateOf("")
    }

    var passLimit = 10

    Column(
        modifier = Modifier.background(Color(0xFFBFEAEE)),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Card(
            modifier = Modifier
                .size(width = 120.dp, height = 40.dp)
                .align(Alignment.End),
            shape = RoundedCornerShape(
                bottomStart = 16.dp
            )
        ) {

        }

        Column(
            modifier = Modifier.padding(32.dp)
        ) {
            Text(
                text = "Cadastre-se",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0048FF)
            )
            Text(
                text = "Por favor, preencha seu cadastro para prosseguir."
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 32.dp, start = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = {
                    name = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                label = {
                    Text(text = "Nome")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Ascii
                ),
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Add, contentDescription = "")
                }
            )
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                label = {
                    Text(text = "E-mail")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Email, contentDescription = "")
                }
            )
            OutlinedTextField(
                value = password,
                onValueChange = {
                    if (it.length <= passLimit) password = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                label = {
                    Text(text = "Senha")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(imageVector = Icons.Outlined.Lock, contentDescription = "")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.KeyboardArrowRight, contentDescription = "")
                }
            )
            Button(
                onClick = {
                    navController.navigate("consulta")
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "ACESSAR")
                Icon(
                    imageVector = Icons.Outlined
                        .ArrowForward, contentDescription = ""
                )
            }
        }
    }
}