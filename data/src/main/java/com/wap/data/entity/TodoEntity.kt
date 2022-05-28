package com.wap.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ToDo")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true) val toDoId: Long = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "contents") val contents: String,
    @ColumnInfo(name = "isComplete") var isComplete: Boolean
)