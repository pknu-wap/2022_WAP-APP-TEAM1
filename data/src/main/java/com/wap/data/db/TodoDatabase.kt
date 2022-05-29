package com.wap.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wap.data.db.dao.TodoDao
import com.wap.domain.entity.ToDo

@Database(entities = arrayOf(ToDo::class), version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun TodoDao(): TodoDao
}