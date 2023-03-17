package com.clonedsemicolon.dalle2_android.data.source.service

import com.clonedsemicolon.dalle2_android.common.Constants.IMAGE_GENERATE
import com.clonedsemicolon.dalle2_android.data.model.GeneratedImage
import com.clonedsemicolon.dalle2_android.data.model.RequestModel
import retrofit2.http.Body
import retrofit2.http.POST

interface DallEImageGenerateService {

    @POST(IMAGE_GENERATE)
    suspend fun generateImage(@Body body: RequestModel):GeneratedImage
}