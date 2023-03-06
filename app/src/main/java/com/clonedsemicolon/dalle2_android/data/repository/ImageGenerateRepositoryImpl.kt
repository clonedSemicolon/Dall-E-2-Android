package com.clonedsemicolon.dalle2_android.data.repository

import com.clonedsemicolon.dalle2_android.common.ImageProgressStatus
import com.clonedsemicolon.dalle2_android.data.model.RequestModel
import com.clonedsemicolon.dalle2_android.domain.repository.ImageGenerateRepository
import kotlinx.coroutines.flow.flow


class ImageGenerateRepositoryImpl():ImageGenerateRepository {
    override fun generateImage(requestModel: RequestModel) = flow{
        emit(ImageProgressStatus.Loading)
        try {
            val response =
        }
    }
}