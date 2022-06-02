package com.wap.data.local

import android.os.Build
import androidx.annotation.RequiresApi
import com.wap.data.db.dao.ScheduleDao
import com.wap.data.toEntity
import com.wap.data.toSchedule
import com.wap.domain.entity.Schedule
import com.wap.domain.entity.WeekType
import com.wap.domain.datasource.ScheduleDataSource
import java.time.LocalDateTime
import java.time.LocalTime
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
class ScheduleLocalDataSourceImpl @Inject constructor(
    private val scheduleDao: ScheduleDao
) : ScheduleDataSource {

    private fun LocalDateTime.startDateMax() = LocalDateTime.of(this.toLocalDate(), LocalTime.MAX)

    override fun getSchedule(scheduleId: Long): Schedule {
        TODO()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun findSchedulesByUserId(userId: Long) = scheduleDao.findSchedulesByUserId(userId)?.map { scheduleEntity ->
        scheduleEntity.toSchedule()
    } ?: emptyList()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun findSchedulesByStartTime(startTime: LocalDateTime)
    = scheduleDao.findSchedulesByStartDate(startDateMin = startTime, startDateMax = startTime.startDateMax())?.map { scheduleEntity ->
        scheduleEntity.toSchedule()
    } ?: emptyList()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun findScheduleByScheduleId(scheduleId: Long) = scheduleDao.findScheduleByScheduleId(scheduleId)?.toSchedule()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun createSchedule(schedule: Schedule) {
        scheduleDao.insertSchedule(schedule.toEntity())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun updateSchedule(schedule: Schedule) {
        scheduleDao.updateSchedule(schedule.toEntity())
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