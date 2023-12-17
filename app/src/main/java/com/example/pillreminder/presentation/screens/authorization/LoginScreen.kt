package com.example.pillreminder.presentation.screens.authorization

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pillreminder.ui.theme.LocalCustomColorsPalette
import com.example.pillreminder.ui.theme.PillReminderTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(color = MaterialTheme.colorScheme.background)
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
                .padding(top = it.calculateTopPadding())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Text(
                    modifier = Modifier
                        .padding(top = 57.dp),
                    text = "Welcome back!",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = LocalCustomColorsPalette.current.lightGray,
                )
                Text(
                    text = "Login to your Account",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = LocalCustomColorsPalette.current.mediumBlack
                )

                // Email input
                Text(
                    text = "Email",
                    modifier = Modifier
                        .padding(top = 37.dp)
                        .padding(bottom = 12.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = LocalCustomColorsPalette.current.mediumBlack
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(51.dp)
                        .border(
                            width = 1.dp,
                            color = LocalCustomColorsPalette.current.lightGray,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    shape = RoundedCornerShape(12.dp),
                    placeholder = { Text(text = "Enter your Email")},
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        unfocusedIndicatorColor = Color.Transparent,
                        placeholderColor = LocalCustomColorsPalette.current.lightGray,
                    ),
                    value = email,
                    onValueChange = { email = it }
                )
                // Password input
                Text(
                    text = "Password",
                    modifier = Modifier
                        .padding(top = 18.dp)
                        .padding(bottom = 12.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = LocalCustomColorsPalette.current.mediumBlack
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(51.dp)
                        .border(
                            width = 1.dp,
                            color = LocalCustomColorsPalette.current.lightGray,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    shape = RoundedCornerShape(12.dp),
                    placeholder = { Text(text = "Enter your Password")},
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        unfocusedIndicatorColor = Color.Transparent,
                        placeholderColor = LocalCustomColorsPalette.current.lightGray,
                    ),
                    value = password,
                    onValueChange = { password = it }
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = true,
                            onCheckedChange = {},
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color.Green,
                            )
                        )
                        Text(text = "Remember me", color = LocalCustomColorsPalette.current.mediumBlack)
                    }
                    Text(text = "Forgot Password", color = MaterialTheme.colorScheme.primary)
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(12.dp),
                    content = {
                        Text(
                            text = "Send your OTP",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        ) },
                    onClick = { /*TODO*/ }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 38.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Don't have an account? ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = LocalCustomColorsPalette.current.mediumBlack
                )
                Text(
                    text = "Register",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
@Preview
fun LoginScreenPreview() {
    PillReminderTheme {
        LoginScreen()
    }
}