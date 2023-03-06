package com.clonedsemicolon.dalle2_android.domain.repository

import com.clonedsemicolon.dalle2_android.data.model.RequestModel

interface ImageGenerateRepository {
    fun generateImage(requestModel:RequestModel)
}