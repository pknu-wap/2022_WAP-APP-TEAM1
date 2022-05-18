package com.wap.storemanagement.utils

import android.os.Build
import androidx.annotation.RequiresApi
import com.prolificinteractive.materialcalendarview.CalendarDay
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun LocalDateTime.toScheduleDate(): String = format(
    DateTimeFormatter.ofPattern("yyyyMMdd")
)

@RequiresApi(Build.VERSION_CODES.O)
fun CalendarDay.toDate() = hashCode().toString()
