package com.wap.data.entity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.*

@RequiresApi(Build.VERSION_CODES.O)
@Entity(
    tableName = "schedule",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["user_id"])]
)
data class ScheduleEntity(
    @PrimaryKey(autoGenerate = true) val scheduleId: Long = 0,
    val startTime: Long,
    val endTime: Long,
    val color: String,
    val recurWeek: String? = null,
    @ColumnInfo(name = "user_id") val userId: Long
)


