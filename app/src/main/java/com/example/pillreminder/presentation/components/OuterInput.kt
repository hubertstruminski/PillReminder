package com.example.pillreminder.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.pillreminder.ui.theme.CustomColors
import com.example.pillreminder.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OuterInput(
    title: String,
    titleModifier: Modifier = Modifier,
    textFieldModifier: Modifier = Modifier,
    titleStyle: TextStyle = Typography.current.regular14,
    titleColor: Color = CustomColors.current.mediumBlack,
    placeholder: String,
    value: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable () -> Unit = {},
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit
) {
    Text(
        text = title,
        modifier = titleModifier
            .padding(bottom = 12.dp),
        style = titleStyle,
        color = titleColor,
    )
    TextField(
        modifier = textFieldModifier
            .fillMaxWidth()
            .height(51.dp)
            .border(
                width = 1.dp,
                color = CustomColors.current.lightGray,
                shape = RoundedCornerShape(12.dp)
            ),
        shape = RoundedCornerShape(12.dp),
        placeholder = {
            Text(
                text = placeholder,
                style = Typography.current.regular12,
                color = CustomColors.current.lightGray
            )},
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.background,
            unfocusedIndicatorColor = Color.Transparent,
            placeholderColor = CustomColors.current.lightGray,
        ),
        visualTransformation = visualTransformation,
        trailingIcon = trailingIcon,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        value = value,
        onValueChange = onValueChange,
    )
}