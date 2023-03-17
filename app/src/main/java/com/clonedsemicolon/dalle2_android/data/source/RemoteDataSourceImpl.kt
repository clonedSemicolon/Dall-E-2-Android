package com.clonedsemicolon.dalle2_android.data.source

import com.clonedsemicolon.dalle2_android.data.model.GeneratedImage
import com.clonedsemicolon.dalle2_android.data.model.RequestModel
import com.clonedsemicolon.dalle2_android.data.source.service.DallEImageGenerateService
import com.clonedsemicolon.dalle2_android.domain.source.RemoteDataSource

class RemoteDataSourceImpl(private val remoteService:DallEImageGenerateService) : RemoteDataSource {
    override suspend fun generateImage(requestModel: RequestModel):
            GeneratedImage {
        return remoteService.generateImage(requestModel)
    }
}