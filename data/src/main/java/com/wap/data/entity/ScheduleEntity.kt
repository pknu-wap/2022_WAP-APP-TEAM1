package com.wap.data.entity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

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
)


