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
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pillreminder.R
import com.example.pillreminder.presentation.components.OuterInput
import com.example.pillreminder.ui.theme.CustomColors
import com.example.pillreminder.ui.theme.PillReminderTheme
import com.example.pillreminder.ui.theme.Typography
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(color = MaterialTheme.colorScheme.background)
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
                .padding(top = paddingValues.calculateTopPadding())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(modifier = Modifier.padding(top = 57.dp)) {
                Text(
                    text = stringResource(R.string.welcome_back),
                    style = Typography.current.medium16,
                    color = CustomColors.current.lightGray,
                )
                Text(
                    text = stringResource(R.string.auth_title),
                    style = Typography.current.bold24,
                    color = CustomColors.current.mediumBlack
                )
                OuterInput(
                    titleModifier = Modifier.padding(top = 37.dp),
                    title = stringResource(R.string.email),
                    placeholder = stringResource(R.string.enter_your_email),
                    value = email,
                    onValueChange = { email = it }
                )
                OuterInput(
                    titleModifier = Modifier.padding(top = 18.dp),
                    title = stringResource(R.string.password),
                    placeholder = stringResource(R.string.enter_your_password),
                    value = password,
                    onValueChange = { password = it })

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            modifier = Modifier
                                .border(shape = RoundedCornerShape(4.dp), width = 0.dp, color = Color.Transparent),
                            checked = true,
                            onCheckedChange = {},
                            colors = CheckboxDefaults.colors(
                                checkedColor = MaterialTheme.colorScheme.primary,
                            )
                        )
                        Text(text = stringResource(R.string.remember_me), color = CustomColors.current.mediumBlack)
                    }
                    Text(text = stringResource(R.string.forgot_password), color = MaterialTheme.colorScheme.primary)
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(12.dp),
                    content = {
                        Text(
                            text = stringResource(R.string.log_in),
                            style = Typography.current.semiBold14,
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
                    text = stringResource(R.string.don_t_have_an_account),
                    style = Typography.current.medium16,
                    color = CustomColors.current.mediumBlack
                )
                Text(
                    text = stringResource(R.string.register),
                    style = Typography.current.semiBold16,
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