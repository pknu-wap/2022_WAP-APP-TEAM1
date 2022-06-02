package com.wap.data.db

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.wap.data.db.dao.ScheduleDao
import com.wap.data.db.dao.TodoDao
import com.wap.data.db.dao.UserDao
import com.wap.data.entity.ScheduleEntity
import com.wap.data.entity.TodoEntity
import com.wap.data.entity.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Database(entities = [ScheduleEntity::class, UserEntity::class, TodoEntity::class], version = 3)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun scheduleDao(): ScheduleDao

    abstract fun userDao(): UserDao

    abstract fun toDoDao(): TodoDao

    companion object {

        fun getInstance(context: Context): AppDatabase = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "database"
        ).addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    getInstance(context).userDao().insertUser(
                        UserEntity(userId = 1L, name = "은빈")
                    )
                }
            }
        })
            .fallbackToDestructiveMigration()
            .build()
    }
}
