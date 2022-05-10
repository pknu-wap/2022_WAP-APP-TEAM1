package com.wap.domain.entity

import java.time.LocalDateTime

data class Schedule(
    val scheduleId: Long, // 기본키
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val color: String,
    val recurWeek: WeekType? = null,
    val userId: Long, // 외래키
)

enum class WeekType {
    SUN,
    MON,
    TUE,
    WED,
    THU,
    FRI,
    SAT
}