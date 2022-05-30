package com.wap.data.db

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wap.data.db.dao.ScheduleDao
import com.wap.data.db.dao.TodoDao
import com.wap.data.db.dao.UserDao
import com.wap.data.entity.ScheduleEntity
import com.wap.data.entity.TodoEntity
import com.wap.data.entity.UserEntity

@RequiresApi(Build.VERSION_CODES.O)
@Database(entities = [ScheduleEntity::class, UserEntity::class, TodoEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun ScheduleDao(): ScheduleDao

    abstract fun UserDao(): UserDao

    abstract fun toDoDao(): TodoDao

    companion object {
        private var INSTANCE : AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase? {
            if(INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "database")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}