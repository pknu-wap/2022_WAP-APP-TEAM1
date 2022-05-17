package com.wap.data.util

import android.os.Build
import androidx.annotation.RequiresApi
import com.wap.domain.entity.WeekType
import java.time.LocalDateTime
import java.time.ZoneOffset

@RequiresApi(Build.VERSION_CODES.O)
fun fromLocalDateTime(time: LocalDateTime?) = time?.toEpochSecond(ZoneOffset.of("+09:00"))

@RequiresApi(Build.VERSION_CODES.O)
fun toLocalDateTime(time: Long?) = time?.let {
    LocalDateTime.ofEpochSecond(time, 0, ZoneOffset.of("+09:00"))
}

fun fromRecurWeek(recurWeek: WeekType?): String? = when (recurWeek) {
    WeekType.SUN -> "SUN"
    WeekType.MON -> "MON"
    WeekType.TUE -> "TUE"
    WeekType.WED -> "WED"
    WeekType.THU -> "THU"
    WeekType.FRI -> "FRI"
    WeekType.SAT -> "SAT"
    else -> null
}

fun toRecurWeek(recurWeek: String?): WeekType? = when (recurWeek) {
    "SUN" -> WeekType.SUN
    "MON" -> WeekType.MON
    "TUE" -> WeekType.TUE
    "WED" -> WeekType.WED
    "THU" -> WeekType.THU
    "FRI" -> WeekType.FRI
    "SAT" -> WeekType.SAT
    else -> null
}
