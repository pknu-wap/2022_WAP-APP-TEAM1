package com.wap.storemanagement.fake

import com.wap.storemanagement.data.entity.ScheduleEntity

object FakeFactory {

    fun createSchedules(): List<ScheduleEntity> = listOf(
        ScheduleEntity(id = 1, contents = "글자 아무거나"),
        ScheduleEntity(id = 2, contents = "글 아무거나"),
        ScheduleEntity(id = 3, contents = "글자아무거나"),
        ScheduleEntity(id = 4, contents = "글자 아무거나ㄴㄹㄴ"),
        ScheduleEntity(id = 5, contents = "글자ㄴㄴ아무거나"),
        ScheduleEntity(id = 6, contents = "글자ㄷㄷㄷㄷ무거나"),
    )
}