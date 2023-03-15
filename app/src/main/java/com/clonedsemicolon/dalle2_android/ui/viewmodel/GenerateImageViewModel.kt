package com.clonedsemicolon.dalle2_android.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.engine.Resource
import com.clonedsemicolon.dalle2_android.data.model.GeneratedImage
import com.clonedsemicolon.dalle2_android.data.model.RequestModel
import com.clonedsemicolon.dalle2_android.domain.usecase.GenerateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class GenerateImageViewModel @Inject constructor(private val generateUseCase:GenerateUseCase) : ViewModel() {

    private val _state = MutableStateFlow<Resource<GeneratedImage>?>(null)
    val state = _state.asStateFlow()


    fun generateImageFromPrompt(requestModel: RequestModel){
        generateUseCase.generate(requestModel).collect{
            _state.emit(it)
        }

        }
    }


