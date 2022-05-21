package com.wap.data.db.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.wap.data.db.AppDatabase
import com.wap.data.toEntity
import com.wap.domain.entity.Schedule
import com.wap.domain.entity.WeekType
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.time.LocalDateTime

class ScheduleDaoTest {

    private lateinit var db: AppDatabase

    private lateinit var dao: ScheduleDao

    @Before
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        dao = db.ScheduleDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun when_findSchedulesByUserId_then_success() {
        // Given insert schedule
        val schedule = Schedule(
            scheduleId = 0L,
            startTime = LocalDateTime.of(2022, 5, 5, 12, 0),
            endTime = LocalDateTime.of(2022, 5, 5, 13, 0),
            color = "",
            recurWeek = WeekType.FRI,
            userId = 1L
        ).toEntity()

        dao.insertSchedule(schedule)

        // When fetch Schedule
        val schedules = dao.findSchedulesByUserId(1L)

        // Then equal initial schedule
        assertEquals(listOf(schedule), schedules)
    }
}
