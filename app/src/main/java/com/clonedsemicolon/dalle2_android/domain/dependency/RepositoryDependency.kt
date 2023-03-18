package com.clonedsemicolon.dalle2_android.domain.dependency

import com.clonedsemicolon.dalle2_android.data.repository.ImageGenerateRepositoryImpl
import com.clonedsemicolon.dalle2_android.data.source.RemoteDataSourceImpl
import com.clonedsemicolon.dalle2_android.data.source.service.DallEImageGenerateService
import com.clonedsemicolon.dalle2_android.domain.repository.ImageGenerateRepository
import com.clonedsemicolon.dalle2_android.domain.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

object RepositoryDependency {

    @Module
    @InstallIn(SingletonComponent::class)
    object RepositoryDependency {

        @Provides
        @Singleton
        fun provideRepository(source: RemoteDataSource): ImageGenerateRepository {
            return ImageGenerateRepositoryImpl(source)
        }
    }
}