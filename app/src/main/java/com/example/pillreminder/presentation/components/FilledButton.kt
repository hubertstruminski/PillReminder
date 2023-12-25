package com.example.pillreminder.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pillreminder.ui.theme.Typography

@Composable
fun FilledButton(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        content = {
            Text(
                text = title,
                style = Typography.current.semiBold14,
                color = Color.White
            )},
        onClick = { onClick.invoke() }
    )
}