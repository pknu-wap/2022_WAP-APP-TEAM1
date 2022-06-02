package com.wap.data.di.module

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.wap.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@RequiresApi(Build.VERSION_CODES.O)
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = AppDatabase.getInstance(context)

    @Provides
    @Singleton
    fun provideScheduleDao(database: AppDatabase) = database.scheduleDao()

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase) = database.userDao()

    @Provides
    @Singleton
    fun provideToDoDao(database: AppDatabase) = database.toDoDao()
}
