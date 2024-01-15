package com.example.pillreminder.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.pillreminder.ui.theme.PillReminderTheme

@Composable
fun CircleIconButton(
    modifier: Modifier = Modifier,
    color: Color
) {
    OutlinedButton(
        modifier = modifier.size(36.dp),
        shape = CircleShape,
        onClick = { /*TODO*/ },
        border = BorderStroke(2.dp, color),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = color)
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add icon",
        )
    }
}

@Preview
@Composable
fun CircleIconButtonPreview() {
    PillReminderTheme {
        CircleIconButton(color = MaterialTheme.colorScheme.primary)
    }
}