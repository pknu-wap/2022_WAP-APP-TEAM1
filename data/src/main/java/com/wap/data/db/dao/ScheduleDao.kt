package com.wap.data.db.dao

import androidx.room.*
import com.wap.data.entity.ScheduleEntity

@Dao
interface ScheduleDao {

    @Insert
    fun insertSchedule(schedule: ScheduleEntity)

    @Query("SELECT * FROM SCHEDULE WHERE user_id = :userId")
    fun findSchedulesByUserId(userId: Long): List<ScheduleEntity>?

    @Query("SELECT * FROM SCHEDULE WHERE startTime = :startTime")
    fun findSchedulesByStartDate(startTime: Long): List<ScheduleEntity>?

    @Update
    fun updateSchedule(schedule: ScheduleEntity)

    @Delete
    fun deleteSchedule(schedule: ScheduleEntity)

}