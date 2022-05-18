package com.wap.storemanagement.di.module

import com.wap.data.local.ScheduleLocalDataSourceImpl
import com.wap.domain.local.ScheduleLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindToDoDataSource(dataSource: ScheduleLocalDataSourceImpl): ScheduleLocalDataSource
}