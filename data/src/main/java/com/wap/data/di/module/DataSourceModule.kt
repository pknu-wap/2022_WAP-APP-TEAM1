package com.wap.data.di.module

import com.wap.data.db.dao.ScheduleDao
import com.wap.data.db.dao.UserDao
import com.wap.data.local.ScheduleLocalDataSourceImpl
import com.wap.data.local.UserLocalDataSource
import com.wap.domain.datasource.ScheduleDataSource
import com.wap.domain.datasource.UserDataSource
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

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class LocalUserDataSource

    @Singleton
    @LocalScheduleDataSource
    @Provides
    fun provideScheduleLocalDataSource(scheduleDao: ScheduleDao): ScheduleDataSource = ScheduleLocalDataSourceImpl(scheduleDao)

    @Singleton
    @LocalUserDataSource
    @Provides
    fun provideScheduleLocalDataSource(userDao: UserDao): UserDataSource = UserLocalDataSource(userDao)
}
