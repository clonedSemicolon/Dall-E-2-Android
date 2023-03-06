package com.clonedsemicolon.dalle2_android.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GenerateImageViewModel @Inject constructor(private val generateUseCase) : ViewModel() {

}