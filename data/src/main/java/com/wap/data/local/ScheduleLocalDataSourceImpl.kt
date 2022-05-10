package com.wap.data.local

import com.wap.domain.entity.Schedule
import com.wap.domain.entity.WeekType
import com.wap.domain.local.ScheduleLocalDataSource
import java.time.LocalDateTime

class ScheduleLocalDataSourceImpl : ScheduleLocalDataSource {

    override fun getSchedule(scheduleId: Long): Schedule {
        TODO("Not yet implemented")
    }

    override fun createSchedule(schedule: Schedule) {
        TODO("Not yet implemented")
    }

    override fun updateStartTime(date: LocalDateTime) {
        TODO("Not yet implemented")
    }

    override fun updateEndTime(date: LocalDateTime) {
        TODO("Not yet implemented")
    }

    override fun updateColor(color: String) {
        TODO("Not yet implemented")
    }

    override fun updateRecurWeek(weekType: WeekType) {
        TODO("Not yet implemented")
    }

    override fun deleteSchedule(scheduleId: Long) {
        TODO("Not yet implemented")
    }
}