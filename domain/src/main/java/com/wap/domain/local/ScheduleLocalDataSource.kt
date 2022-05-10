package com.wap.domain.local

import com.wap.domain.entity.Schedule
import com.wap.domain.entity.WeekType
import java.time.LocalDateTime

interface ScheduleLocalDataSource {

    fun getSchedule(scheduleId: Long): Schedule

    fun createSchedule(schedule: Schedule)

    fun updateStartTime(date: LocalDateTime)

    fun updateEndTime(date: LocalDateTime)

    fun updateColor(color: String)

    fun updateRecurWeek(weekType: WeekType)

    fun deleteSchedule(scheduleId: Long)

}