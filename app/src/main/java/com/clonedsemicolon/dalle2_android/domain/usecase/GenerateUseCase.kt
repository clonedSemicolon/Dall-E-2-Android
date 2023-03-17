package com.clonedsemicolon.dalle2_android.domain.usecase

import com.clonedsemicolon.dalle2_android.data.model.RequestModel
import com.clonedsemicolon.dalle2_android.domain.repository.ImageGenerateRepository
import javax.inject.Inject

class GenerateUseCase @Inject constructor(private val repository: ImageGenerateRepository){
    operator fun invoke(requestModel: RequestModel) = repository.generateImage(requestModel)

}