package com.clonedsemicolon.dalle2_android.data.model

import com.google.gson.annotations.SerializedName

data class RequestModel(
    @SerializedName("prompt")
    val prompt:String,
    @SerializedName("n")
    val n:Int,
    @SerializedName("size")
    val size:String
)
