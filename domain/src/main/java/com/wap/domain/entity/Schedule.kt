package com.wap.domain.entity

import java.time.LocalDateTime

data class Schedule(
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val color: String,
    val recurWeek: WeekType? = null,
    val userId: Long, // 외래키
)

enum class WeekType(val value: String) {
    SUN("일"),
    MON("월"),
    TUE("화"),
    WED("수"),
    THU("목"),
    FRI("금"),
    SAT("토")
}