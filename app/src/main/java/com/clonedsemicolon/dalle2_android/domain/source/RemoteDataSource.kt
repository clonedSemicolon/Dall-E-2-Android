package com.clonedsemicolon.dalle2_android.domain.source

import com.clonedsemicolon.dalle2_android.data.model.RemoteData
import com.clonedsemicolon.dalle2_android.data.model.RequestModel

class RemoteDataSource {
    suspend fun generateImage(requestModel: RequestModel): RemoteData
}