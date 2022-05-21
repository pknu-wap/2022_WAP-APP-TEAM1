package com.wap.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wap.data.db.dao.ScheduleDao
import com.wap.data.db.dao.UserDao
import com.wap.data.entity.ScheduleEntity
import com.wap.data.entity.UserEntity

@Database(entities = [ScheduleEntity::class, UserEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun ScheduleDao() : ScheduleDao
    abstract fun UserDao() : UserDao

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