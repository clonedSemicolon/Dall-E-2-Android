package com.clonedsemicolon.dalle2_android.domain.source

import com.clonedsemicolon.dalle2_android.data.model.GeneratedImage
import com.clonedsemicolon.dalle2_android.data.model.RequestModel

interface RemoteDataSource {
   suspend fun generateImage(requestModel: RequestModel):GeneratedImage
}