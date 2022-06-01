package com.wap.storemanagement.fake

import android.os.Build
import androidx.annotation.RequiresApi
import com.wap.domain.entity.Schedule
import com.wap.domain.entity.WeekType
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
object FakeFactory {

    fun createSchedules() = listOf(
        Schedule(
            scheduleId = -1L,
            startTime = LocalDateTime.of(2022, 5, 5, 12, 0),
            endTime = LocalDateTime.of(2022, 5, 5, 13, 0),
            color = "",
            recurWeek = WeekType.FRI,
            checked = false,
            userId = 1L
        ),
        Schedule(
            scheduleId = -1L,
            startTime = LocalDateTime.of(2022, 5, 6, 15, 0),
            endTime = LocalDateTime.of(2022, 5, 6, 17, 0),
            color = "",
            recurWeek = WeekType.FRI,
            checked = false,
            userId = 1L
        )
    )
}