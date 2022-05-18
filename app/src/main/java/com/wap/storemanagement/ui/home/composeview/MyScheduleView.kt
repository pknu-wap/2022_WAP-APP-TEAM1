package com.wap.storemanagement.ui.home.composeview

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wap.domain.entity.Schedule
import com.wap.storemanagement.R
import com.wap.storemanagement.fake.FakeFactory
import com.wap.storemanagement.ui.basecomposeview.BaseScheduleLazyColumn
import com.wap.storemanagement.ui.basecomposeview.Profile
import com.wap.storemanagement.ui.basecomposeview.formatToString
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScheduleCards(schedules: List<Schedule>) {

    BaseScheduleLazyColumn { scope ->
        scope.items(
            items = schedules,
            key = { schedule -> schedule.scheduleId }
        ) { schedule ->
            val startTime = schedule.startTime.toLocalTime()
            val endTime = schedule.endTime.toLocalTime()
            ScheduleCard(
                name = "getUserNameBySchedule",
                startTime = startTime,
                endTime = endTime
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun ScheduleCard(name: String, startTime: LocalTime, endTime: LocalTime ) {
    val height = dimensionResource(id = R.dimen.home_scheduleCard_height)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Profile(name)
            TimeSchedule(startTime, endTime)
        }
        PinchButton()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TimeSchedule(startTime: LocalTime, endTime: LocalTime) {
    val width = dimensionResource(id = R.dimen.home_timeSchedule_width)
    val height = dimensionResource(id = R.dimen.home_timeSchedule_height)
    val fontSize = 22.sp

    Row(
        modifier = Modifier
            .width(width)
            .height(height),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = startTime.formatToString(), fontSize = fontSize)
        Text(text = "-", fontSize = fontSize)
        Text(text = endTime.formatToString(), fontSize = fontSize)
    }
}

@Composable
fun PinchButton(){
    val size = dimensionResource(id = R.dimen.home_pinchButton_size)
    val pinchButtonColor = colorResource(id = R.color.home_pinch_button_color)

    IconButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.size(size)
    ) {
        Icon(
            imageVector = Icons.Default.Send,
            contentDescription = "send",
            tint = pinchButtonColor
        )
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewGreeting() {
    ScheduleCards(FakeFactory.createSchedules())
}