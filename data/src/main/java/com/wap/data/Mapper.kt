package com.wap.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.wap.data.entity.ScheduleEntity
import com.wap.data.util.fromLocalDateTime
import com.wap.data.util.fromRecurWeek
import com.wap.data.util.toLocalDateTime
import com.wap.data.util.toRecurWeek
import com.wap.domain.entity.Schedule

@RequiresApi(Build.VERSION_CODES.O)
fun ScheduleEntity.toSchedule() = Schedule(
    scheduleId = scheduleId,
    startTime = toLocalDateTime(startTime),
    endTime = toLocalDateTime(endTime),
    color = color,
    recurWeek = toRecurWeek(recurWeek),
    userId = userId
)

@RequiresApi(Build.VERSION_CODES.O)
fun Schedule.toEntity() = ScheduleEntity(
    scheduleId = scheduleId,
    startTime = fromLocalDateTime(startTime),
    endTime = fromLocalDateTime(endTime),
    color = color,
    recurWeek = fromRecurWeek(recurWeek),
    userId = userId
)
