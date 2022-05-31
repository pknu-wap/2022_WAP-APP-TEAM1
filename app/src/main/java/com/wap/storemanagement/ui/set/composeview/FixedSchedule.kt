package com.wap.storemanagement.ui.set.composeview

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wap.domain.entity.Schedule
import com.wap.domain.entity.WeekType
import com.wap.storemanagement.R
import com.wap.storemanagement.ui.basecomposeview.AddScheduleCard
import com.wap.storemanagement.ui.basecomposeview.BaseScheduleLazyColumn
import com.wap.storemanagement.ui.basecomposeview.ScheduleCard
import com.wap.storemanagement.ui.basecomposeview.SubTitle

@Composable
fun CalendarFixedScheduleTitle() {
    SubTitle(text = stringResource(id = R.string.set_calender_fixed_schedule_sub_title))
}

@Composable
fun SelectWeek() {
    val selectedOption = remember { mutableStateOf("") }
    val week = WeekType.values()
    val onSeletionChange = { dayOfWeek: WeekType ->
        selectedOption.value = dayOfWeek.name
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        week.forEach { dayOfWeek ->
            BaseClickableWeek(
                dayOfWeek = dayOfWeek,
                isHaveSchedule = true,
                onSeletionChange = onSeletionChange,
                selectedOption = selectedOption.value
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SelectedRecurSchedules(
    schedules: List<Schedule>,
    onClickAdd: () -> Unit,
    onClickSchedule: (Schedule) -> Unit
) {

    BaseScheduleLazyColumn { scope ->
        scope.items(
            items = schedules,
            key = { schedule -> schedule.scheduleId }
        ) { schedule ->
            val startTime = schedule.startTime.toLocalTime()
            val endTime = schedule.endTime.toLocalTime()
            ScheduleCard(
                startTime = startTime,
                endTime = endTime,
                onClick = { onClickSchedule(schedule) },
                checked = {}
            )
        }
        scope.item { AddScheduleCard(onClick = onClickAdd) }
    }
}

@Composable
private fun BaseClickableWeek(
    dayOfWeek: WeekType,
    isHaveSchedule: Boolean,
    onSeletionChange: (WeekType) -> Unit,
    selectedOption: String
) {
    val borderColor = colorResource(id = R.color.sky_blue)
    val onSelectedColor = colorResource(id = R.color.focused_indicator_color)
    val shape = CircleShape

    Box(
        modifier = Modifier
            .height(40.dp)
            .width(40.dp)
            .graphicsLayer(shape = shape)
            .background(
                color = (
                    if (dayOfWeek.name == selectedOption) {
                        onSelectedColor
                    } else {
                        Color.White
                    }
                    ),
                shape = shape
            )
            .border(
                width = (
                    if (dayOfWeek.name == selectedOption) {
                        0.dp
                    } else {
                        if (isHaveSchedule) 2.dp else 0.dp
                    }
                    ),
                color = borderColor,
                shape = shape
            ),
        contentAlignment = Alignment.Center
    ) {
        ClickableText(
            onClick = { onSeletionChange(dayOfWeek) },
            text = AnnotatedString(
                text = dayOfWeek.value,
                spanStyle = SpanStyle(
                    if (dayOfWeek.name == selectedOption) {
                        Color.White
                    } else {
                        Color.Black
                    }
                )
            )
        )
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
private fun PreviewFixedSchedule() {
    Column {
        CalendarFixedScheduleTitle()
        SelectWeek()
    }
}
