package com.wap.storemanagement.di.module

import com.wap.base.provider.DispatcherProvider
import com.wap.storemanagement.di.provider.DispatcherProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DispatcherModule {

    @Binds
    fun bindDispatcherModule(provider: DispatcherProviderImpl): DispatcherProvider
}