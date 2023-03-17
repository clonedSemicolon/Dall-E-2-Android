package com.clonedsemicolon.dalle2_android.data.repository

import com.bumptech.glide.load.engine.Resource
import com.clonedsemicolon.dalle2_android.common.ImageProgressStatus
import com.clonedsemicolon.dalle2_android.data.model.RequestModel
import com.clonedsemicolon.dalle2_android.domain.repository.ImageGenerateRepository
import com.clonedsemicolon.dalle2_android.domain.source.RemoteDataSource
import kotlinx.coroutines.flow.flow


class ImageGenerateRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
):ImageGenerateRepository {
    override fun generateImage(requestModel: RequestModel) = flow{
        emit(ImageProgressStatus.Loading)
        try {
            val response = remoteDataSource.generateImage(requestModel)
            emit(ImageProgressStatus.Success(response))
        }catch (ex:Exception){
            emit(ImageProgressStatus.Error(ex))
        }
    }
}