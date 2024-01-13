package com.example.pillreminder.presentation.screens.authorization

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pillreminder.R
import com.example.pillreminder.presentation.components.FilledButton
import com.example.pillreminder.presentation.components.OuterInput
import com.example.pillreminder.presentation.components.TextCheckbox
import com.example.pillreminder.ui.theme.CustomColors
import com.example.pillreminder.ui.theme.PillReminderTheme
import com.example.pillreminder.ui.theme.Typography
import com.example.pillreminder.util.isValidEmail
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navigateToRegister: () -> Unit,
    logIn: (email: String, password: String) -> Unit
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(color = MaterialTheme.colorScheme.background)

    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isRememberMeChecked = remember { mutableStateOf(false) }

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
                    onValueChange = { password = it }
                )
                TextCheckbox(
                    rowModifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    title = stringResource(R.string.remember_me),
                    isChecked = isRememberMeChecked
                )
                FilledButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    title = stringResource(R.string.log_in),
                    onClick = {
                        if(email.isNotEmpty() && password.isNotEmpty()) {
                            if(isValidEmail(email)) {
                                logIn(email, password)
                            } else {
                                Toast.makeText(context, "Email is incorrect!", Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                    }
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
                    modifier = Modifier
                        .clickable { navigateToRegister.invoke() },
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
        LoginScreen(navigateToRegister = {}, logIn = { email, password -> })
    }
}