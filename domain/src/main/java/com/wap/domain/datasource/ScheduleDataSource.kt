package com.wap.domain.datasource

import com.wap.domain.entity.Schedule
import com.wap.domain.entity.WeekType
import java.time.LocalDateTime

interface ScheduleDataSource {

    fun getSchedule(scheduleId: Long): Schedule

    fun findSchedulesByUserId(userId: Long): List<Schedule>

    fun findSchedulesByStartTime(startTime: LocalDateTime): List<Schedule>

    fun createSchedule(schedule: Schedule)

    fun updateStartTime(date: LocalDateTime)

    fun updateEndTime(date: LocalDateTime)

    fun updateColor(color: String)

    fun updateRecurWeek(weekType: WeekType)

    fun deleteSchedule(scheduleId: Long)

}
