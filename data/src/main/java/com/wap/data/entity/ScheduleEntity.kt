package com.wap.data.entity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.wap.domain.entity.Schedule
import com.wap.domain.entity.WeekType
import java.time.LocalDateTime
import java.time.ZoneOffset

@RequiresApi(Build.VERSION_CODES.O)
@Entity(
    tableName = "schedule",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ScheduleEntity(
    @PrimaryKey val scheduleId: Long,
    val startTime: Long,
    val endTime: Long,
    val color: String,
    val recurWeek: String? = null,
    @ColumnInfo(name = "user_id") val userId: Long
) {

    fun toSchedule(): Schedule = Schedule(
        scheduleId = scheduleId,
        startTime = LocalDateTime.ofEpochSecond(startTime, 0, ZoneOffset.of("+09:00")),
        endTime = LocalDateTime.ofEpochSecond(startTime, 0, ZoneOffset.of("+09:00")),
        color = color,
        recurWeek = when (recurWeek) {
            "SUN" -> WeekType.SUN
            "MON" -> WeekType.MON
            "TUE" -> WeekType.TUE
            "WED" -> WeekType.WED
            "THU" -> WeekType.THU
            "FRI" -> WeekType.FRI
            "SAT" -> WeekType.SAT
            else -> null
        },
        userId = userId
    )

    companion object {

        fun fromSchedule(schedule: Schedule): ScheduleEntity = ScheduleEntity(
            scheduleId = schedule.scheduleId,
            startTime = schedule.startTime.toEpochSecond(ZoneOffset.of("+09:00")),
            endTime = schedule.endTime.toEpochSecond(ZoneOffset.of("+09:00")),
            color = schedule.color,
            recurWeek = when (schedule.recurWeek) {
                WeekType.SUN -> "SUN"
                WeekType.MON -> "MON"
                WeekType.TUE -> "TUE"
                WeekType.WED -> "WED"
                WeekType.THU -> "THU"
                WeekType.FRI -> "FRI"
                WeekType.SAT -> "SAT"
                else -> null
            },
            userId = schedule.userId
        )
    }
}