package com.wap.data.di.module

import android.content.Context
import androidx.room.Room
import com.wap.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "AppDatabase.db"
    )
        .build()

    @Provides
    @Singleton
    fun provideScheduleDao(database: AppDatabase) = database.ScheduleDao()

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase) = database.UserDao()
}