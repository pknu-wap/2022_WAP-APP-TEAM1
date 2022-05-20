package com.wap.data.di.module

import com.wap.data.db.dao.ScheduleDao
import com.wap.data.local.ScheduleLocalDataSourceImpl
import com.wap.domain.datasource.ScheduleDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataSourceModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalScheduleDataSource

    @Singleton
    @LocalScheduleDataSource
    @Provides
    fun provideScheduleLocalDataSource(scheduleDao: ScheduleDao): ScheduleDataSource = ScheduleLocalDataSourceImpl(
        scheduleDao
    )
}
