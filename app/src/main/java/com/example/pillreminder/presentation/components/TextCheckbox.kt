package com.example.pillreminder.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pillreminder.ui.theme.CustomColors
import com.example.pillreminder.ui.theme.PillReminderTheme

@Composable
fun TextCheckbox(
    rowModifier: Modifier = Modifier,
    checkboxModifier: Modifier = Modifier,
    title: String,
    isChecked: MutableState<Boolean>
) {
    Row(
        modifier = rowModifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            modifier = checkboxModifier
                .border(shape = RoundedCornerShape(4.dp), width = 0.dp, color = Color.Transparent),
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = !isChecked.value },
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.primary,
                uncheckedColor = CustomColors.current.lightGray,
            )
        )
        Text(text = title, color = CustomColors.current.mediumBlack)
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun TextCheckboxPreview() {
    val isChecked = mutableStateOf(true)
    PillReminderTheme {
        TextCheckbox(isChecked = isChecked, title = "Remember me")
    }
}