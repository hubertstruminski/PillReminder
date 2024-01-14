package com.example.pillreminder.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pillreminder.R
import com.example.pillreminder.presentation.widgets.HorizontalDatePicker
import com.example.pillreminder.ui.theme.CustomColors
import com.example.pillreminder.ui.theme.PillReminderTheme
import com.example.pillreminder.ui.theme.Typography
import kotlin.math.log

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(logout: () -> Unit) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(23.dp)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu icon")
                }
                Row {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notifications icon")
                    }
                    IconButton(onClick = logout) {
                        Icon(painter = painterResource(id = R.drawable.logout), contentDescription = "Logout icon")
                    }
                }

            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding() + 30.dp)
                .padding(horizontal = 16.dp)
        ) {
                Text(
                    text = "Hello, Lance Bogrol",
                    style = Typography.current.bold24,
                    color = CustomColors.current.mediumBlack
                )
                Text(
                    modifier = Modifier
                        .padding(top = 3.dp),
                    text = "We will remind you of the medicines you need to take today.",
                    style = Typography.current.regular14,
                    color = CustomColors.current.lightGray
                )
                HorizontalDatePicker()
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    PillReminderTheme {
        HomeScreen(logout = {})
    }
}