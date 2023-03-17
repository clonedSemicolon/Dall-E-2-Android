package com.clonedsemicolon.dalle2_android.domain.repository

import com.clonedsemicolon.dalle2_android.common.ImageProgressStatus
import com.clonedsemicolon.dalle2_android.data.model.GeneratedImage
import com.clonedsemicolon.dalle2_android.data.model.RequestModel
import kotlinx.coroutines.flow.Flow

interface ImageGenerateRepository {
    fun generateImage(requestModel:RequestModel): Flow<ImageProgressStatus<GeneratedImage>>
}