package com.wap.storemanagement.data.entity

import java.util.*

// FIXME : 더미데이터
data class ScheduleEntity(
    val id: Long,
    val contents: String,
    val date: Date = Date()
)