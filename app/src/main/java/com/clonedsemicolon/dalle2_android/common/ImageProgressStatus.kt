package com.clonedsemicolon.dalle2_android.common

sealed class ImageProgressStatus<out T : Any> {
    object Loading : ImageProgressStatus<Nothing>()
    data class Success<out T : Any>(val data: T) : ImageProgressStatus<T>()
    data class Error(val throwable: Throwable) : ImageProgressStatus<Nothing>()
}