package com.example.pillreminder.presentation.widgets

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pillreminder.ui.theme.CustomColors
import com.example.pillreminder.ui.theme.PillReminderTheme
import com.example.pillreminder.ui.theme.Typography
import java.time.LocalDate
import kotlin.math.abs

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HorizontalDatePicker(chosenDate: MutableState<LocalDate>) {
    val pageCount = Int.MAX_VALUE
    val middlePage = pageCount / 2

    val today = LocalDate.now()

    fun createDate(index: Int): LocalDate? {
        val scrollIndex = index - middlePage
        val from = LocalDate.from(today)
        var day: LocalDate? = if(scrollIndex > 0) {
            from.plusDays(scrollIndex.toLong())
        } else {
            from.minusDays(abs(scrollIndex.toLong()))
        }
        return day
    }

    LazyRow(
        modifier = Modifier.padding(vertical = 30.dp),
        state = LazyListState(firstVisibleItemIndex = middlePage),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(count = Int.MAX_VALUE) {index ->
            Surface(
                modifier = Modifier
                    .height(85.dp)
                    .width(58.dp)
                    .clickable {
                        val scrollIndex = index - middlePage
                        Log.d("scrollIndex: ", "$scrollIndex")

                        chosenDate.value = createDate(index) ?: LocalDate.now()
                    },
                shape = RoundedCornerShape(8.dp),
                shadowElevation = 8.dp
            ) {
                val date = createDate(index)
                val isToday = middlePage == index
                val fontColor = if(isToday) Color.White else CustomColors.current.mediumBlack
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(if (isToday) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary)
                        .padding(vertical = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = date?.dayOfMonth.toString(),
                        style = Typography.current.semiBold16,
                        color = fontColor
                    )
                    Text(
                        text = date?.month.toString().substring(0, 3),
                        style = Typography.current.medium16,
                        color = fontColor
                    )
                    Text(
                        text = date?.year.toString(),
                        style = Typography.current.regular14,
                        color = fontColor
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun HorizontalDatePickerPreview() {
    var chosenDate = remember { mutableStateOf(LocalDate.now()) }

    PillReminderTheme {
        HorizontalDatePicker(chosenDate = chosenDate)
    }
}