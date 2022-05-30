package com.wap.storemanagement.di.module

import android.os.Build
import androidx.annotation.RequiresApi
import com.wap.data.db.dao.TodoDao
import com.wap.data.di.module.DataSourceModule
import com.wap.data.local.ToDoLocalDataSource
import com.wap.data.repository.ScheduleRepository
import com.wap.domain.datasource.ScheduleDataSource
import com.wap.domain.datasource.ToDoDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @RequiresApi(Build.VERSION_CODES.O)
    @Singleton
    @Provides
    fun provideScheduleRepository(
        @DataSourceModule.LocalScheduleDataSource localScheduleDataSource: ScheduleDataSource
    ): ScheduleRepository = ScheduleRepository(
        localScheduleDataSource
    )

    @Singleton
    @Provides
    fun provideToDoLocalDataSource(todoDao: TodoDao): ToDoDataSource = ToDoLocalDataSource(todoDao)
}
