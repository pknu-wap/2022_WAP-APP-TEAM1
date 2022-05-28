package com.wap.data.db.dao

import androidx.room.*
import com.wap.data.entity.ScheduleEntity
import java.time.LocalDateTime

@Dao
interface ScheduleDao {

    // Insert
    @Insert
    fun insertSchedule(schedule: ScheduleEntity)


    // Find
    @Query("SELECT * FROM SCHEDULE WHERE user_id = :userId")
    fun findSchedulesByUserId(userId: Long): List<ScheduleEntity>?

    @Query("SELECT * FROM SCHEDULE WHERE startTime = :startTime")
    fun findSchedulesByStartDate(startTime: LocalDateTime): List<ScheduleEntity>?

    @Query("SELECT * FROM SCHEDULE WHERE scheduleId= :scheduleId")
    fun findScheduleByScheduleId(scheduleId: Long): ScheduleEntity

    // Update
    @Update
    fun updateSchedule(schedule: ScheduleEntity)


    // Delete
    @Query("DELETE FROM SCHEDULE WHERE user_id = :userId")
    fun deleteSchedulesByUserId(userId: Long)

    @Query("DELETE FROM SCHEDULE WHERE startTime =:startTime")
    fun deleteScheduleByStartTime(startTime: LocalDateTime)

}
