package com.clonedsemicolon.dalle2_android.domain.dependency

import com.clonedsemicolon.dalle2_android.data.source.RemoteDataSourceImpl
import com.clonedsemicolon.dalle2_android.data.source.service.DallEImageGenerateService
import com.clonedsemicolon.dalle2_android.domain.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceDependency {

    @Provides
    @Singleton
    fun provideDataSource(service:DallEImageGenerateService):RemoteDataSource{
        return RemoteDataSourceImpl(service)
    }
}