package com.example.pillreminder.presentation.screens.authorization

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pillreminder.R
import com.example.pillreminder.presentation.components.FilledButton
import com.example.pillreminder.presentation.components.OuterInput
import com.example.pillreminder.presentation.components.TextCheckbox
import com.example.pillreminder.presentation.widgets.BackArrowTopBar
import com.example.pillreminder.ui.theme.CustomColors
import com.example.pillreminder.ui.theme.PillReminderTheme
import com.example.pillreminder.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navigateToLogin: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val isRememberMeChecked = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            BackArrowTopBar(
                navigateToLogin = navigateToLogin
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background)
                .padding(top = paddingValues.calculateTopPadding())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(modifier = Modifier.padding(top = 37.dp)) {
                Text(
                    text = stringResource(R.string.welcome),
                    style = Typography.current.medium16,
                    color = CustomColors.current.lightGray,
                )
                Text(
                    text = stringResource(R.string.create_an_account),
                    style = Typography.current.bold24,
                    color = CustomColors.current.mediumBlack
                )
                OuterInput(
                    titleModifier = Modifier.padding(top = 40.dp),
                    title = stringResource(R.string.username),
                    placeholder = stringResource(R.string.enter_your_username),
                    value = username,
                    onValueChange = { username = it }
                )
                OuterInput(
                    titleModifier = Modifier.padding(top = 18.dp),
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
                    title = stringResource(R.string.create_account),
                    onClick = {}
                )
            }
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    PillReminderTheme {
        RegisterScreen(navigateToLogin = {})
    }
}