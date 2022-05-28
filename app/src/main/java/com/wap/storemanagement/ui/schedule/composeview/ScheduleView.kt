package com.wap.storemanagement.ui.schedule.composeview

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wap.domain.entity.Schedule
import com.wap.storemanagement.fake.FakeFactory
import com.wap.storemanagement.ui.basecomposeview.AddScheduleCard
import com.wap.storemanagement.ui.basecomposeview.BaseScheduleLazyColumn
import com.wap.storemanagement.ui.basecomposeview.ScheduleCard
import com.wap.storemanagement.ui.basecomposeview.keyForScheduleLazyColumn

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ScheduleView(schedules: List<Schedule>, onClickAdd: () -> Unit) {

    BaseScheduleLazyColumn { scope ->
        scope.items(
            items = schedules,
            key = { schedule -> schedule.keyForScheduleLazyColumn() }
        ) { schedule ->
            val startTime = schedule.startTime.toLocalTime()
            val endTime = schedule.endTime.toLocalTime()
            ScheduleCard(startTime = startTime, endTime = endTime)
        }
        scope.item { AddScheduleCard(onClick = onClickAdd) }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun PreviewScheduleView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        // ScheduleView(FakeFactory.createSchedules())
    }
}
