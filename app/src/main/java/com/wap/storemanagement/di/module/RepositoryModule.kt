package com.wap.storemanagement.di.module

import com.wap.data.di.module.DataSourceModule
import com.wap.data.repository.ScheduleRepository
import com.wap.domain.datasource.ScheduleDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideScheduleRepository(
        @DataSourceModule.LocalScheduleDataSource localScheduleDataSource: ScheduleDataSource
    ): ScheduleRepository = ScheduleRepository(
        localScheduleDataSource
    )
}
